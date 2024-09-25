class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: If needle is an empty string, return 0
        if (needle.length() == 0) {
            return 0;
        }

        int len = haystack.length();
        int lenn = needle.length();

        // Iterate through the haystack
        for (int i = 0; i <= len - lenn; i++) {
            int j = 0;
            // Check if the substring of haystack starting at i matches needle
            while (j < lenn && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == lenn) {
                return i; // Return the starting index of the match
            }
        }

        // If no match is found, return -1
        return -1;
    }
}