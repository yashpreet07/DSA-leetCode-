// Optimized Using Two Pointers
// Passed 29 test cases but its doesn't work cause of the 2nd constraint not being followed
// "For all integers with the same sign, the order in which they were present in nums is preserved."
// class Solution {
//     public int[] rearrangeArray(int[] nums) {
//         int i = 0;
//         int j = 1;
//         while(i < nums.length && j < nums.length){
//             if(nums[i] > 0)
//             i += 2;
//             else if(nums[j] < 0)
//             j += 2;
//             else{
//                 int temp = nums[i];
//                 nums[i] = nums[j];
//                 nums[j] = temp;
//             }
//         }
//     return nums;
//     }
// }

/*
The issue in your implementation lies in the swapping logic: although it ensures the numbers alternate correctly (positive and negative), it doesn’t preserve the relative order of elements with the same sign. To fix this, we can use a different approach that avoids swapping and directly builds the rearranged array while maintaining the original order.
 */

 class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int posIndex = 0; // Pointer for placing positive numbers
        int negIndex = 1; // Pointer for placing negative numbers

        // Traverse the input array and place numbers at their correct positions
        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2; // Move to the next positive index
            } else {
                result[negIndex] = num;
                negIndex += 2; // Move to the next negative index
            }
        }

        return result;
    }
}