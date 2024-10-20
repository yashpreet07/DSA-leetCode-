// Set<Integer> occurrenceSet = new HashSet<>(countMap.values());You didn't know you could do this!!!

// class Solution {
//     public boolean uniqueOccurrences(int[] arr) {
//         Map<Integer, Integer> countMap = new HashMap<>();
        
//         // Count occurrences of each element
//         for (int x : arr) {
//             countMap.put(x, countMap.getOrDefault(x, 0) + 1);
//         }
        
//         // Check if the counts of occurrences are unique
//         Set<Integer> occurrenceSet = new HashSet<>(countMap.values());
        
//         // If the size of occurrenceSet is the same as the countMap values, all occurrences are unique
//         return occurrenceSet.size() == countMap.size();
//     }
// }

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count occurrences of each element
        for (int x : arr) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }
        
        // Use a single HashSet to check if occurrences are unique
        Set<Integer> occurrenceSet = new HashSet<>();
        
        // Iterate over the values in the map (which represent occurrences)
        for (int count : countMap.values()) {
            // If the set already contains this count, it's not unique
            if (!occurrenceSet.add(count)) {
                return false;
            }
        }
        
        // If all counts were unique, return true
        return true;
    }
}