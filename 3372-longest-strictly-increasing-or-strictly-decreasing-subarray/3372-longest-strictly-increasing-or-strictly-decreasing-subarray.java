// Wrong Implementation
// class Solution {
//     public int longestMonotonicSubarray(int[] nums) {
//         int i = 0;
//         int j = 1;
//         int c1 = 1, c2 = 1;
//         if(nums.length == 1)
//         return 1;
//         while(j < nums.length){
//             if(nums[j] > nums[i])
//                 c1++;
//             i++;
//             j++;
//         }
//         i = 0;
//         j = 1;
//         while(j < nums.length){
//             if(nums[j] < nums[i])
//                 c2++;
//             i++;
//             j++;
//         }
//         return Math.max(c1,c2);
//     }
// }
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) return 1;
        
        int inc = 1, dec = 1;
        int maxInc = 1, maxDec = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;  // Reset decreasing count
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;  // Reset increasing count
            } else {
                inc = 1;
                dec = 1;
            }
            maxInc = Math.max(maxInc, inc);
            maxDec = Math.max(maxDec, dec);
        }
        
        return Math.max(maxInc, maxDec);
    }
}