/* Your Code passed 67 test case then failed.
 You miss understood the question Only Handeled Consecutive element Instead of random which was asked.
for example:
nums = [1,5,0,4,1,3]
your answer will be false but its true
as i = 2(0)
   j = 4(1)
   k = 5(3)
Your code works only for Substring not subsequence.
 */
// class Solution {
//     public boolean increasingTriplet(int[] nums) {
//         int i = 0;
//         int j;
//         int k;
//         do{
//             j = i + 1;
//             k = i + 2;
//             if(j > nums.length - 1 || k > nums.length - 1)
//                 return false;
//             if((nums[i] < nums[j]) && (nums[j] < nums[k]))
//                 return true;
//             else
//             i++;
//         }while(i < nums.length);
//     return true;
//     }
// }

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        // Initialize two variables to store the smallest and second smallest numbers
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        // Loop through the array
        for (int num : nums) {
            if (num <= first) {
                first = num;  // Update 'first' to the current number if it's the smallest so far
            } else if (num <= second) {
                second = num;  // Update 'second' if it's the second smallest number after 'first'
            } else {
                // If we find a number larger than both 'first' and 'second', we found a triplet
                return true;
            }
        }
        
        // If no increasing triplet is found, return false
        return false;
    }
}