class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        StringBuffer sb = new StringBuffer(s);
        int i = 0;
            while(!sb.isEmpty() && i < n){
                if(Character.isDigit(sb.charAt(i))){
                    sb.delete(i - 1,i + 1);
                    i = -1;
                    n = sb.length();
                }
                i++;
            }
        return sb.toString();
    }
}