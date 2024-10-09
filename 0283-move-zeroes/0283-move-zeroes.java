class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while(j > i)
        {
            if(nums[i] == 0)
            {
                int k = i;
                while(k < nums.length - 1)
                {
                    nums[k] = nums[k+1];
                    k++;
                }
                nums[j] = 0;
                j--; 
            }
            else
            i++;
        }
    }
}