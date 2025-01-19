class Solution {
    boolean check(int []arr,int m){
        if(m == arr.length - 1) return true;
        return (arr[m] > arr[m + 1]);
    }
    public int findPeakElement(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int ans = 0;
        if(arr.length == 1)
            return ans;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(check(arr,mid)){
                ans = mid;
                hi = mid - 1;
            }
            else
                lo = mid + 1;
        }
        return ans;
    }
}