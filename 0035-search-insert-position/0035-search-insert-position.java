/* This is question can be treated as a property!!!
that after the search space gets gets exhausted in a binary search the
lower bound(l) will always points towards the index where the element 
should have appeared had it been there in the array.
*/
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int u = nums.length - 1;
        while (l <= u) {
            int mid = l + (u - l) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid])
                l = mid + 1;
            else
                u = mid - 1;
        }
        return l;
    }
}