class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int close = n;
        int open = n;
        String op = "";
        solve(open,close,op);
        return res;
    }
    void solve(int open,int close,String op){
        // BC:
        if(close == 0 && open == 0){
            res.add(op);
            return;
        }
        if(open != 0){
            String op1 = op;
            op1 += "(";
            solve(open - 1,close,op1);
        }
        if(close > open){
            String op2 = op;
            op2 += ")";
            solve(open,close - 1,op2);
        }
        return;
    }
}