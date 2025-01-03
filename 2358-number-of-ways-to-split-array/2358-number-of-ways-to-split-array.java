// Your code use long data type here
// class Solution {
//     public int waysToSplitArray(int[] nums) {
//         int n = nums.length;
//         int count = 0;
//         int[] ps = new int[n];
//         ps[0] = nums[0];
//         for (int i = 1; i < n; i++) {
//             ps[i] = nums[i] + ps[i - 1];
//         }
//         for (int i = 0; i < n - 1; i++) {
//             int sumL = ps[i];
//             int sumR = ps[n - 1] - ps[i];
//             if (sumL >= sumR) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }
// With long data type
// class Solution {
//     public int waysToSplitArray(int[] nums) {
//         int n = nums.length;
//         int count = 0;
//         long[] ps = new long[n]; // Use long to prevent overflow
//         ps[0] = nums[0];
        
//         // Calculate prefix sum
//         for (int i = 1; i < n; i++) {
//             ps[i] = nums[i] + ps[i - 1];
//         }
        
//         // Count the valid splits
//         for (int i = 0; i < n - 1; i++) {
//             long sumL = ps[i]; // Use long
//             long sumR = ps[n - 1] - ps[i]; // Use long
//             if (sumL >= sumR) {
//                 count++;
//             }
//         }
        
//         return count;
//     }
// }
// Most optimized code
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        int count = 0;
        
        // Calculate the total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // Calculate prefix sum and count valid splits
        long prefixSum = 0;
        for (int i = 0; i < n - 1; i++) {
            prefixSum += nums[i];
            long suffixSum = totalSum - prefixSum;
            if (prefixSum >= suffixSum) {
                count++;
            }
        }
        
        return count;
    }
}