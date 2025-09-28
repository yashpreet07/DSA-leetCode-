// App-1
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int lSum[] = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            lSum[i] = (i != 0) ? (lSum[i - 1] + nums[i]) : nums[i];
        }
        int rSum[] = new int[nums.length];
        for(int i = nums.length - 1;i >=0;i--){
            rSum[i] = (i != nums.length - 1) ? ( rSum[i + 1] + nums[i]) : nums[i];
        }
        int ans[] = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            ans[i] = Math.abs(lSum[i] - rSum[i]);
        }
    return ans;
    }
}