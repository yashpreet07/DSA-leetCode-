// Your Code Without Using PrefixSum Beats 12%
// class Solution {
//     public int lrSum(String str,boolean lr)
//     {
//         if(lr){
//             int rSum = 0;
//             for(int i = 0;i < str.length();i++)
//             {
//                 if(str.charAt(i) == '1')
//                 rSum++;
//             }
//             return rSum;
//         }
//         else{
//             int lSum = 0;
//             for(int i = 0;i < str.length();i++)
//             {
//                 if(str.charAt(i) == '0')
//                 lSum++;
//             }
//             return lSum;
//         }
//     }
//     public int maxScore(String s) {
//         int maxSum = 0;
//         // I missed this s.length() - 1 insted wrote s.length() that generated a logical error.
//         for(int i = 0;i < s.length() - 1;i++){
//             int sum = 0;
//             sum += lrSum(s.substring(0,i + 1),false);
//             sum += lrSum(s.substring(i + 1),true);
//             maxSum = Math.max(sum,maxSum);
//         }
// return maxSum;
//     }
// }
// Using Prefix Sum Beats 40%
// class Solution {
//     public int maxScore(String s) {
//         int n = s.length();
//         int[] prefixZero = new int[n]; // To store prefix sum of zeros
//         int[] prefixOne = new int[n];  // To store prefix sum of ones

//         // Calculate prefix sums for zeros and ones
//         prefixZero[0] = (s.charAt(0) == '0') ? 1 : 0;
//         prefixOne[n - 1] = (s.charAt(n - 1) == '1') ? 1 : 0;

//         for (int i = 1; i < n; i++) {
//             prefixZero[i] = prefixZero[i - 1] + ((s.charAt(i) == '0') ? 1 : 0);
//         }

//         for (int i = n - 2; i >= 0; i--) {
//             prefixOne[i] = prefixOne[i + 1] + ((s.charAt(i) == '1') ? 1 : 0);
//         }

//         // Find the maximum score by splitting the string
//         int maxSum = 0;
//         for (int i = 0; i < n - 1; i++) { // Split point cannot be at the end
//             int leftSum = prefixZero[i];    // Sum of zeros in the left part
//             int rightSum = prefixOne[i + 1]; // Sum of ones in the right part
//             maxSum = Math.max(maxSum, leftSum + rightSum);
//         }

//         return maxSum;
//     }
// }
// Most Optimized code
class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int leftZeros = 0, rightOnes = 0, maxSum = 0;

        // Count total ones in the string for the initial right part
        for (char c : s.toCharArray()) {
            if (c == '1') rightOnes++;
        }

        // Iterate through the string and calculate the score for each split
        for (int i = 0; i < n - 1; i++) {
            // Update left zeros count
            if (s.charAt(i) == '0') leftZeros++;
            // Update right ones count
            if (s.charAt(i) == '1') rightOnes--;

            // Calculate current score and update maxSum
            maxSum = Math.max(maxSum, leftZeros + rightOnes);
        }

        return maxSum;
    }
}