class Solution {
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> temp = new ArrayList<>();
        Set<String> setDict = new HashSet<>();
        for (String str : wordDict){
            setDict.add(str);
        }
        solve(s,setDict,temp,0);
        return res;
    }
    void solve(String s,Set<String> setDict,List<String> temp,int start){
        // Base Case:
        if(start == s.length()){
            res.add(spaceSep(temp));
            return;
        }
        StringBuilder wrd = new StringBuilder();
        for(int i = start;i < s.length();i++){
            wrd.append(s.charAt(i));
            if(setDict.contains(wrd.toString())){
                temp.add(wrd.toString());

                solve(s,setDict,temp,i + 1);

                temp.remove(temp.size() - 1);
            }
        } 
    }
    public String spaceSep(List<String> temp){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < temp.size();i++){
            sb.append(temp.get(i));
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}