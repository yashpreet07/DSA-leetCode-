class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        // First pass: count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Second pass: find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i; // Return the index of the first unique character
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