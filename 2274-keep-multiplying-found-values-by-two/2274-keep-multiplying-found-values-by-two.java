// class Solution {
//     boolean isFound(int[]arr,int tar)
//     {
//         Arrays.sort(arr);
//         int u = arr.length - 1;
//         int l = 0;
//         while(l <= u)
//         {
//             int mid = u + (l - u) / 2;
//             if(tar == arr[mid])
//                 return true;
//             else
//                 if(tar > arr[mid])
//                     l = mid + 1;
//                 else
//                 u = mid - 1;
//         }
//         return false;
//     }
//     public int findFinalValue(int[] nums, int original) {
//        while(isFound(nums,original))
//         original *= 2;
//     return original;
//     }
// }
class Solution {
     public int findFinalValue(int[] nums, int original) {
        int i = 0;
        while(i <= nums.length - 1)
        {
            if(nums[i] == original)
            {
                original *= 2;
                i = 0;
            }
            else
                i++;
        }
return original;
    }
}