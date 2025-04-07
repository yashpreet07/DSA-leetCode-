class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        solve(s,temp,0);
        return res;
    }
    public boolean isValidPalin(String str){
        int i = 0 , j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    void solve(String s, List<String> temp,int start){
        // Base Case:
        if(start == s.length()){
            res.add(new ArrayList(temp));
            return;
        }
        // Choice loop:
        StringBuilder palinS = new StringBuilder();
        for(int i = start;i < s.length();i++){
            palinS.append(s.charAt(i));
            if(isValidPalin(palinS.toString())){
                temp.add(palinS.toString());

                solve(s,temp,i + 1);

                // Backtrack
                temp.remove(temp.size() - 1);
            }
        }
    }
}