// class Solution {
//     public String addSpaces(String s, int[] spaces) {
//         int i = 0;
//         int j = 0;
//         StringBuffer sb = new StringBuffer();
//         while (i < s.length()) {
//             if (j < spaces.length && spaces[j] == i) {
//                 sb.append(" ");
//                 j++;
//             } else {
//                 sb.append(s.charAt(i));
//                 i++;
//             }
//         }
//         return sb.toString();
//     }
// }
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s.length() + spaces.length);
        int j = 0; // Pointer for spaces array
        int prev = 0; // Track the start of the next substring to append

        // Iterate through the spaces array
        for (int space : spaces) {
            // Append the substring between `prev` and the current space index
            sb.append(s, prev, space);
            // Add the space
            sb.append(" ");
            // Update the starting point for the next chunk
            prev = space;
        }

        // Append the remaining part of the string after the last space
        sb.append(s.substring(prev));
        
        return sb.toString();
    }
}