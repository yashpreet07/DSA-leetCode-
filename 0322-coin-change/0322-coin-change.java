class Solution {
    public int coinChange(int[] coins, int amt) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amt + 1];
        // Initialization : 
        for(int i = 1 ;i < n + 1;i++){
            dp[i][0] = 0;
        }
        for(int j = 0 ;j < amt + 1;j++){
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        // Special Initialisation for 2nd row:
        for(int j = 1 ;j < amt + 1;j++){
            if(j % coins[0] == 0)
                dp[1][j] = j / coins[0];
            else
                dp[1][j] = Integer.MAX_VALUE - 1;
        }
        // CODE:
        for(int i = 2;i < n + 1;i++){
            for(int j = 1;j < amt + 1;j++){
                if(coins[i - 1] <= j){
                    dp[i][j] = Math.min((1 + dp[i][j - coins[i - 1]]) , dp[i - 1][j]);
                }else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][amt] ==  Integer.MAX_VALUE - 1 ? -1 :  dp[n][amt];
    }
}