class Solution {
    public boolean canConstruct(String s, int k) {
        // Base case: If k is greater than the string length, it's impossible
        if (k > s.length()) return false;

        // Frequency array for characters 'a' to 'z'
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Count odd frequencies
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // Check if it's possible to form k palindromes
        return oddCount <= k;
    }
}