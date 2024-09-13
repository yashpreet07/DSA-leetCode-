import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashSet to store elements in the current window of size k
        HashSet<Integer> set = new HashSet<>();

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            // If the element is already in the set, return true
            if (set.contains(nums[i])) {
                return true;
            }
            
            // Add the current element to the set
            set.add(nums[i]);
            
            // Ensure the size of the window doesn't exceed k
            if (set.size() > k) {
                set.remove(nums[i - k]); // Remove the element that is now out of the window
            }
        }
        return false;
    }
}