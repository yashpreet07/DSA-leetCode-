import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> digitSumGroups = new HashMap<>();
        
        // Step 1: Calculate the digit sum for each number from 1 to n and group them
        for (int i = 1; i <= n; i++) {
            int digitSum = getDigitSum(i);
            digitSumGroups.put(digitSum, digitSumGroups.getOrDefault(digitSum, 0) + 1);
        }
        
        // Step 2: Find the maximum size of the groups
        int maxSize = 0;
        for (int size : digitSumGroups.values()) {
            maxSize = Math.max(maxSize, size);
        }
        
        // Step 3: Count the number of groups with the maximum size
        int count = 0;
        for (int size : digitSumGroups.values()) {
            if (size == maxSize) {
                count++;
            }
        }
        
        return count;
    }
    
    // Helper function to calculate the sum of digits of a number
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}