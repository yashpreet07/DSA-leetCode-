class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        
        // Binary search to find the starting point
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) 
                left = mid + 1;
            else 
                right = mid;
        }

        // Extract k elements from arr[left] to arr[left + k - 1]
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        
        return res; // No need to sort as elements are already in order
    }
}