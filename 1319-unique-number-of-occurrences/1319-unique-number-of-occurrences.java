class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count occurrences of each element
        for (int x : arr) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }
        
        // Check if the counts of occurrences are unique
        Set<Integer> occurrenceSet = new HashSet<>(countMap.values());
        
        // If the size of occurrenceSet is the same as the countMap values, all occurrences are unique
        return occurrenceSet.size() == countMap.size();
    }
}