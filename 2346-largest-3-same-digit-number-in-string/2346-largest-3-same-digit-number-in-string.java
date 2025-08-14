class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            if (c == num.charAt(i + 1) && c == num.charAt(i + 2)) {
                String triple = num.substring(i, i + 3);
                if (ans.equals("") || triple.compareTo(ans) > 0) {
                    ans = triple;
                }
            }
        }
        return ans;
    }
}