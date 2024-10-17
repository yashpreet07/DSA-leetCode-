import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        
        // Use sets to remove duplicates and store unique values
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for (int x : nums1) {
            set1.add(x);
        }
        
        for (int x : nums2) {
            set2.add(x);
        }
        
        // Find elements in set1 that are not in set2
        List<Integer> lst1 = new ArrayList<>();
        for (int x : set1) {
            if (!set2.contains(x)) {
                lst1.add(x);
            }
        }
        
        // Find elements in set2 that are not in set1
        List<Integer> lst2 = new ArrayList<>();
        for (int x : set2) {
            if (!set1.contains(x)) {
                lst2.add(x);
            }
        }
        
        ans.add(lst1);
        ans.add(lst2);
        
        return ans;
    }
}