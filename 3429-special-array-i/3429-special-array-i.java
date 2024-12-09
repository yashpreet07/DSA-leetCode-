class Solution {
    public boolean isArraySpecial(int[] nums) {
        int i = 0;
        int j = 1;
        if(nums.length == 1)
        return true;
        while(j < nums.length)
        {
            if(nums[i] % 2 == nums[j] % 2)
                return false;
            i++;
            j++;
        }
    return true;
    }
}