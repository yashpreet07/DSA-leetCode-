class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        
        // Perform binary search to find the position where the k-th missing number lies
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1); // Calculate missing numbers up to index `mid`
            
            if (missing < k) {
                low = mid + 1; // Move right if fewer than k numbers are missing
            } else {
                high = mid - 1; // Move left if k or more numbers are missing
            }
        }
        
        // After binary search, `low` is the index where the k-th missing number lies
        // Calculate the k-th missing number
        return k + high + 1;
    }
}