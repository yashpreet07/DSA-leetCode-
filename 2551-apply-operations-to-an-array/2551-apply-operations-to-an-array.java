class Solution {
    public int[] applyOperations(int[] nums) {
        // Doing the operations
        for(int i = 0;i < nums.length;i++){
            if(i != nums.length - 1 && nums[i] == nums[i + 1]){
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0; 
            }
        }

        // Moving Zeroes at the end.
        int res[] = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        for(int k = 0;k < nums.length;k++){
            if(nums[k] != 0){
                res[i] = nums[k];
                i++;
            }
            else{
                res[j] = nums[k];
                j--;
            }
        }
        return res;
        // int i = 0;
        // int j = nums.length - 1;
        // while(i < j){
        //     if(nums[i] == 0 && nums[j] != 0){
        //         int temp = nums[i];
        //         nums[i] = nums[j];
        //         nums[j] = temp;
        //         i++;
        //         j--;
        //     }
        //     if(nums[i] != 0)
        //             i++;
        //     if(nums[j] == 0)
        //             j--;
        // }
    }
}