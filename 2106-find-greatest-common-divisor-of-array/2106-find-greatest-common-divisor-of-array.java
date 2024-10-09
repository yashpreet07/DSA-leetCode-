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

private int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }
    // public int GCD(int x,int y)
    // {
    //     int min=Math.min(x,y);
    //     int gcd=1;
    //     for(int i=1;i<=min;i++)
    //     {
    //         if(x%i==0 && y%i==0)
    //             gcd=i;
    //     }
    // return gcd;
    // }
}