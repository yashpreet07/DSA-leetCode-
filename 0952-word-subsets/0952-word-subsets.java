import java.util.*;

class Solution {
    public static boolean isSubset(int[] wordFreq, int[] targetFreq) {
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] < targetFreq[i]) {
                return false; // If word doesn't satisfy the target frequencies
            }
        }
        return true;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Step 1: Compute the maximum frequency requirement for words2
        int[] targetFreq = new int[26];
        for (String b : words2) {
            int[] freq = new int[26];
            for (char c : b.toCharArray()) {
                freq[c - 'a']++;
                targetFreq[c - 'a'] = Math.max(targetFreq[c - 'a'], freq[c - 'a']);
            }
        }

        // Step 2: Filter words1 based on the combined requirement
        List<String> res = new ArrayList<>();
        for (String a : words1) {
            int[] wordFreq = new int[26];
            for (char c : a.toCharArray()) {
                wordFreq[c - 'a']++;
            }
            if (isSubset(wordFreq, targetFreq)) {
                res.add(a); // Add word if it satisfies the target frequencies
            }
        }

        return res;
    }
}