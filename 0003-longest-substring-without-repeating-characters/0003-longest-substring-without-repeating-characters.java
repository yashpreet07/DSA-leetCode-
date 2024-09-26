
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
                /*	•j - i is correct when j has already moved past the last valid character in the window.
•j - i + 1 would be used if j were still pointing to the last character inside the window (i.e., if you hadn’t moved j yet).
                */
            } else {
                // If the character at j is in the set, remove the character at i and move i forward
                set.remove(s.charAt(i));
                i++;
            }
        }
        
        return maxSize;
    }
}


// Futher Space Optimized solution
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         // Array to store the last index of each character
//         int[] lastIndex = new int[128];  // Assuming ASCII
//         for (int k = 0; k < 128; k++) {
//             lastIndex[k] = -1;  // Initialize all positions to -1
//         }
        
//         int i = 0;  // Left pointer of the window
//         int maxSize = 0;  // Max size of the substring without repeating characters

//         for (int j = 0; j < s.length(); j++) {
//             char currentChar = s.charAt(j);
            
//             // If the character has been seen before, move the left pointer to the right of the previous occurrence
//             if (lastIndex[currentChar] >= i) {
//                 i = lastIndex[currentChar] + 1;
//             }
            
//             // Update the last seen index of the current character
//             lastIndex[currentChar] = j;

//             // Update the maximum size
//             maxSize = Math.max(maxSize, j - i + 1);
//         }
        
//         return maxSize;
//     }
// }