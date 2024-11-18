/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// Binary Search Works on Sorted Search Space not just Sorted Arrays.
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int u = n;
        while(l <= u)
        {
           int mid = l + (u - l) / 2;
            if(isBadVersion(mid))
            u = mid - 1;
            else
            l = mid + 1; 
        }
        return l;
    }
}