class Solution {
    public int scoreOfString(String s) {
        int i = 0;
        int j = 1;
        int len = s.length();
        int sc = 0;
        while(j < len)
        {
            sc += Math.abs(s.charAt(i) - s.charAt(j));
            i++;
            j++;
        }
        return sc;
    }
}