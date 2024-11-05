// Your code doesn't handel all the test cases.
// class Solution {
//     // Helper function to calculate minimum changes to make all characters in a string '0' or '1'
//     public int minOneZeros(String str) {   
//         int ones = 0;
//         int zeros = 0;
//         for (int i = 0; i < str.length(); i++) {
//             if (str.charAt(i) == '1')
//                 ones++;
//             else if (str.charAt(i) == '0')
//                 zeros++;
//         }
//         // Return minimum changes to make the substring all '1's or all '0's
//         return Math.min(ones, zeros);
//     }

//     public int minChanges(String s) {
//         int len = s.length();

//         // Edge case: if the string length is 1, no changes are needed
//         if (len == 1) {
//             return 0;
//         }
        
//         // Edge case: if the string length is 2, calculate min changes directly without splitting
//         if (len == 2) {
//             return minOneZeros(s);  // Make both characters the same
//         }

//         // Split the string into two halves for general cases
//         String subString1 = s.substring(0, len / 2);
//         String subString2 = s.substring(len / 2);

//         // Calculate changes needed for each half to be uniform
//         int changesForFirstHalf = minOneZeros(subString1);
//         int changesForSecondHalf = minOneZeros(subString2);
        
//         // Total changes
//         int totalChanges = changesForFirstHalf + changesForSecondHalf;
//         return totalChanges;
//     }
// }

public class Solution {
    public int minChanges(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}