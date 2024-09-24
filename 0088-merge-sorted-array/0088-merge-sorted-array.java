// Your Code failing to pass the test case
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int i = 0;
//         int j = 0;
//         int k = 0;
//         while(i < m && j < n)
//         {
//             if(nums1[i] < nums2[j])
//                 nums1[k++] = nums1[i++];
//             else
//                 nums1[k++] = nums2[j++];
//         }
//         while(i < m)
//             nums1[k++] = nums1[i++];
//         while(j < n)
//             nums1[k++] = nums2[j++];
//     }
// }
/*The Core Problem:

As you merge starting from the beginning (k = 0), you are overwriting elements in nums1, which you still need to compare against nums2. This causes the test case to fail because your result won’t be accurate.

Correct Approach:

To avoid overwriting elements in nums1, you should merge from the end of nums1 backward. This ensures that the largest elements are placed in the empty slots (at the back of nums1) first, and you don’t overwrite any useful values during the process.
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // Pointer for nums1
        int j = n - 1;  // Pointer for nums2
        int k = m + n - 1;  // Pointer for the merged array (starting from the end)

        // Merge nums1 and nums2 starting from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are any remaining elements in nums2, copy them over
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}