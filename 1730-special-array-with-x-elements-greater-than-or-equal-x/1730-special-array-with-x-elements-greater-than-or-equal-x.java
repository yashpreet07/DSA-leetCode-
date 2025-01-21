class Solution {
    int check(int a[],int m,int x){
        if(a[m] >= x)
        return 1;
        else
        return 0;
    }
    public int lowerBound(int arr[],int x){
            int lo = 0;
            int hi = arr.length - 1;
            int ans = arr.length - 1;
            while(lo <= hi){
                int mid = (hi + lo) / 2;
                if(check(arr,mid,x) == 1){
                    ans = mid;
                    hi = mid - 1;
                }
                else
                    lo = mid + 1;
            }
        return ans;
    }
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        int val = nums[n];
        for(int i = 0;i <= val;i++){
                int total = n - lowerBound(nums,i) + 1;
                if (total == i)
                    return i;
        }
        return -1;
    }
}