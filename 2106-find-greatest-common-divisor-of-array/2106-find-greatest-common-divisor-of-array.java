class Solution {
    public int findGCD(int[] nums) {
        int s=nums[0];
        int l=0;
        for(int i : nums){
            s=Math.min(s,i);
            l=Math.max(l,i);
        }
    return GCD(s,l);
    }

    public int GCD(int x,int y)
    {
        int max=Math.max(x,y);
        int gcd=1;
        for(int i=1;i<=max;i++)
        {
            if(x%i==0 && y%i==0)
                gcd=Math.max(gcd,i);
        }
    return gcd;
    }
}