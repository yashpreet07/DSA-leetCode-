// Your implementation has a bug because the initial value of maxAvg is set to 0.0. This can result in a situation where, if all the subarray averages are negative, the correct maximum average is not computed properly, as it will never be higher than 0.0.
// class Solution {
//     public double findMaxAverage(int[] nums, int k) {
//         int i = 0;
//         int j = k;
//         int len = nums.length;
//         if(len == 1)
//         return nums[0];
//         double avg = 0.0;
//         double maxAvg = 0.0;
//         while(j <= len)
//         {   double sum = 0.0;
//             for(int a = i; a < j; a++)
//                 sum += nums[a];
//             avg = sum / k;
//             maxAvg = Math.max(avg,maxAvg);
//             i++;
//             j++;
//         }
//    return maxAvg;
//     }
// }
	/* 1.	Initialization of maxAvg: Start with the average of the first k elements instead of 0.0.
	2.	Sliding Window Optimization: Instead of recalculating the sum in each iteration using a nested loop, maintain a running sum and update it by adding the next element and subtracting the previous element.*/

// class Solution {
    // public double findMaxAverage(int[] nums, int k) {
        // int len = nums.length;
        
//         // Calculate the sum of the first 'k' elements
//         double sum = 0.0;
//         for (int i = 0; i < k; i++) {
//             sum += nums[i];
//         }
        
//         // Initialize maxAvg as the average of the first subarray of length k
//         double maxAvg = sum / k;
        
//         // Use a sliding window to calculate the sum of subsequent subarrays of length k
//         for (int i = k; i < len; i++) {
//             sum = sum + nums[i] - nums[i - k];
//             double avg = sum / k;
//             maxAvg = Math.max(maxAvg, avg);
//         }
        
//         return maxAvg;
//     }
// }
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first 'k' elements
        double maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        // Initialize currentSum with maxSum
        double currentSum = maxSum;

        // Use the sliding window to calculate the sum for the rest of the subarrays
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];  // Slide the window by subtracting the element that goes out and adding the element that comes in
            maxSum = Math.max(maxSum, currentSum);  // Track the maximum sum
        }

        // Return the maximum average
        return maxSum / k;
    }
}