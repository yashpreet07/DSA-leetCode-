class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        sb.append(s.charAt(0)); // Always add the first character

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1; // Reset count for a new character
            }

            if(count < 3) {
                sb.append(s.charAt(i)); // Only add if less than 3 repeating
            }
        }

        return sb.toString();
    }
}