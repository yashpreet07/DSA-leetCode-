// Your code doen't work
// class Solution {
//     public int countPalindromicSubsequence(String s) {
//         int n = s.length();
//         int totalSubsequences = 1 << n; // 2^n
//         int count = 0;

//         for (int mask = 0; mask < totalSubsequences; mask++) {
//             StringBuilder subsequence = new StringBuilder();

//             // Generate subsequence for the current mask
//             for (int i = 0; i < n; i++) {
//                 if ((mask & (1 << i)) != 0) { // Check if the i-th bit is set
//                     subsequence.append(s.charAt(i));
//                 }
//             }
//             if(subsequence.length() == 3 && subsequence.charAt(0) == subsequence.charAt(2))
//             count++;
//         }

//         return count;
//     }
// }
class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int count = 0;

        // Array to store the first and last occurrence of each character
        int[] first = new int[26];
        int[] last = new int[26];

        // Initialize first occurrence to -1
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
        }

        // Populate first and last occurrence for each character
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (first[index] == -1) {
                first[index] = i;
            }
            last[index] = i;
        }

        // Count palindromic subsequences of length 3
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && last[i] > first[i]) { // Valid range exists
                HashSet<Character> uniqueChars = new HashSet<>();
                // Collect unique characters between first[i] and last[i]
                for (int j = first[i] + 1; j < last[i]; j++) {
                    uniqueChars.add(s.charAt(j));
                }
                // Add the count of unique characters
                count += uniqueChars.size();
            }
        }

        return count;
    }
}