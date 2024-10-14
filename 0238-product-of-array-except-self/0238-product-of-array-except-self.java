class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        ans[n - 1] = nums[n - 1];
        for (int i = n-2;i >= 0;i--)
           ans[i] = ans[i+1] * nums[i];
        int lPro = 1;
        for(int i = 0;i < n;i++)
        {
            int rPro = (i == n-1) ? 1 : ans[i+1];
            ans[i] = lPro*rPro;
            lPro *= nums[i];
        }
       return ans;
    }
}