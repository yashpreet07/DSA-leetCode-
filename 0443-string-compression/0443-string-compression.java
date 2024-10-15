// Your Code Full of error.
// class Solution {
//     public int compress(char[] chars) {
//         StringBuilder s = new StringBuilder(String.valueOf(chars));

//         int i = 0;
//         int len = s.length();
//         while (i < len) {
//             int j = s.lastIndexOf((s.charAt(i)));
//             if (i == j) {
//                 s.insert(i, s.charAt(i));
//                 i++;
//             } else {
//                 s.insert(i, s.charAt(i));
//                 s.insert(i + 1, String.valueOf(j - i + 1));
//                 i = j + 1;
//             }
//         }
//         chars = s.toString().toCharArray();
//         return chars.length;
//     }
// }
// Wrong Solution came from your approach!!!
// class Solution {
//     public int compress(char[] chars) {
//         StringBuilder s = new StringBuilder(String.valueOf(chars));

//         int i = 0;  // Pointer for traversing the string
//         int len = s.length();

//         while (i < len) {
//             char currentChar = s.charAt(i);
//             int j = i;  // Initialize j to start from the same point as i
            
//             // Find the last occurrence of the current character in the consecutive sequence
//             while (j < len && s.charAt(j) == currentChar) {
//                 j++;
//             }
            
//             // Calculate the length of the sequence
//             int count = j - i;
            
//             // Insert the compressed version
//             if (count > 1) {
//                 s.delete(i + 1, j);  // Remove repeated characters
//                 s.insert(i + 1, String.valueOf(count));  // Insert count after the character
//                 len = s.length();  // Update the length after modification
//             }
            
//             // Move to the next character
//             i += (count > 1) ? 2 : 1;
//         }
        
//         // Convert the modified StringBuilder back to the char array
//         chars = s.toString().toCharArray();
//         return chars.length;
//     }
// }
class Solution {
    public int compress(char[] chars) {
        int write = 0;  // Pointer to write compressed characters
        int i = 0;  // Pointer to traverse the chars array
        
        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;
            
            // Count the number of consecutive occurrences of chars[i]
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }
            
            // Write the character
            chars[write] = currentChar;
            write++;
            
            // Write the count if greater than 1
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write] = c;
                    write++;
                }
            }
        }
        
        // Return the length of the compressed array
        return write;
    }
}