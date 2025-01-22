// Your Solution 
// class Solution {
//     public int missingNumber(int[] nums) {
//         Arrays.sort(nums);
//         int n = nums.length;
//         int i = 0;
//         for(;i < nums.length;i++){
//             if(nums[i] != i)
//                 return i;
//         }
//     return i == n ? i : -1;
//     }
// }
// Taking sum approach
// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         int sum = ((n) * (n + 1)) / 2;
//         for(int i = 0; i < n;i++){
//             sum -= nums[i];
//         }
//         return sum;
//     }
// }
// XOR solution
class Solution {
    public int missingNumber(int[] nums) { // xor
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}