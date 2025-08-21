class Solution {
    public int change(int amt, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amt + 1];
        // Initialization
        for(int i = 0;i < n + 1;i++){
            dp[i][0] = 1;
        }
        for(int j = 1;j < amt + 1;j++){
            dp[0][j] = 0;
        }

        // Code:
        for(int i = 1;i < n + 1;i++){
            for(int j = 1;j < amt + 1;j++){
                if(coins[i - 1] <= j){
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i - 1][j];
                }
                
            }
        }
        return dp[n][amt];
    }
}