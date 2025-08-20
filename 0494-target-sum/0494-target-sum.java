class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int ele : nums){
            sum += ele;
        }
        // important condition
        if((sum + target) % 2 != 0 || Math.abs(target) > sum)
            return 0;
            
        int ss = Math.abs((sum + target) / 2);
        int n = nums.length;
        int dp[][] = new int[n + 1][ss + 1];
        
        dp[0][0] = 1;
        for(int i = 1;i < n + 1;i++){
            for(int j = 0;j < ss + 1;j++){
                if(nums[i - 1] <= j){
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][ss];
    }
}