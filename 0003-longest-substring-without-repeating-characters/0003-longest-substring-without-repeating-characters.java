import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxSize = 0;
        int len = s.length();
        HashSet<Character> set = new HashSet<>();
        
        while (j < len) {
            // If the character at j is not in the set, add it and move j forward
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                // Update maxSize if the current window is larger
                maxSize = Math.max(maxSize, j - i);
            } else {
                // If the character at j is in the set, remove the character at i and move i forward
                set.remove(s.charAt(i));
                i++;
            }
        }
        
        return maxSize;
    }
}