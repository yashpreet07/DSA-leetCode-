class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        String op = "";
        String ip = s;
        solve(op,ip);
        return res;
    }
    void solve(String op ,String ip){
        if(ip.length() == 0){
            res.add(op);
            return;
        }
        if(Character.isLetter(ip.charAt(0))){
            String op1 = op;
            String op2 = op;
            op1 = op1 + Character.toUpperCase(ip.charAt(0));
            op2 = op2 + Character.toLowerCase(ip.charAt(0));
            ip = ip.substring(1);
            solve(op1,ip);
            solve(op2,ip);
            return;
        }else{
            String op1 = op;
            op1 = op1 + ip.charAt(0);
            ip = ip.substring(1);
            solve(op1,ip);
        }
    }
}