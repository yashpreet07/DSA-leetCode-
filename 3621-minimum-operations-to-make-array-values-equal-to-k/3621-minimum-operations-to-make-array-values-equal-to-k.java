import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> uniqueValues = new HashSet<>();
        boolean hasSmallerThanK = false;

        for (int num : nums) {
            if (num < k) {
                hasSmallerThanK = true;
            } else if (num > k) {
                uniqueValues.add(num);
            }
        }

        if (hasSmallerThanK) {
            return -1;
        }

        return uniqueValues.size();
    }
}