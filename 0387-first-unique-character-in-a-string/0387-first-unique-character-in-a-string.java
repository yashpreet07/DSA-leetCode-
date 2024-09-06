class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();

        // Loop through each character of the string
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);

            // Check if the first and last occurrence of the character are the same
            if (s.indexOf(currentChar) == s.lastIndexOf(currentChar)) {
                return i; // First unique character found, return its index
            }
        }

        return -1; // No unique character found
    }
}
// TLE Solution
// public int count(String str, char c) {
// int count = 0;
// for (char ch : str.toCharArray()) {
// if (ch == c)
// count++;
// }
// return count;
// }
// public int firstUniqChar(String s) {
// int len = s.length()-1;
// for (int i = 0; i <= len; i++) {
// if (count(s, s.charAt(i)) == 1)
// return i;
// }
// return -1;