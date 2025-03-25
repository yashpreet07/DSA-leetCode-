class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int temp[] = new int[nums.length];
        int k = 0;
        for(int i : nums){
            temp[k] = i;
            k++;
        }
        Arrays.sort(temp);
        for(int i = 0;i < nums.length;i++){
            int j = 0;
            int count = 0;
            while(nums[i] > temp[j]){
                count++;
                j++;
            }
            nums[i] = count;
        }
        return nums;
    }
}