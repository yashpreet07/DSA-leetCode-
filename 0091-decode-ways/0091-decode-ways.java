class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        dp[n]=1;

        for(int i= n-1;i>=0;i--)
        {
            //First character is a zero invalid case.

            if(s.charAt(i) == '0')
                dp[i] = 0;
            else
            {
                int takeOneDigits=dp[i+1];
                int takeTwoDigits = 0;
                if(i <= (n-2))
                {
                    // check if the resultant number formed from the 2 digit is <=26
                    int no=(s.charAt(i)-'0')*10 + (s.charAt(i+1) -'0');
                    if(no <= 26)
                        takeTwoDigits = dp[i+2];
                }
                dp[i] = takeOneDigits + takeTwoDigits;
            }
        }
        return dp[0];
    }
}