class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String rStr = removeNonAlphaNum(s);
        int i = 0;
        int j = rStr.length() - 1;
        while (j >= i) {
            if (rStr.charAt(i) != rStr.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

 public String removeNonAlphaNum(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Only add if the character is a letter or a digit
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}