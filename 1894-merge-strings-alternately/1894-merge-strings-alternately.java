// Your Code!!!
// class Solution {
//     public String mergeAlternately(String word1, String word2) {
//         StringBuilder sb = new StringBuilder();
//         int l1=word1.length();
//         int l2=word2.length();
//         int len = Math.max(l1,l2);
//         for(int i = 0; i < len; i++)
//         {
//             if(i < l1)
//                 sb.append(word1.charAt(i));
//             if(i < l2)
//             sb.append(word2.charAt(i));
//         }
    
//     return sb.toString();
//     }
// }

// Bit more optimized code.
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0, l1 = word1.length(), l2 = word2.length();
        
        // Merge the common part
        while (i < l1 && i < l2) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        
        // Append the remaining part of word1, if any
        if (i < l1) {
            sb.append(word1.substring(i));
        }
        
        // Append the remaining part of word2, if any
        if (i < l2) {
            sb.append(word2.substring(i));
        }

        return sb.toString();
    }
}