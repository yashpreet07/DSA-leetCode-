// You missed the edge case and kept getting indexOut Of Bound Exp.
// class Solution {
//     public boolean isSubsequence(String s, String t) {
//         if(s == "null" || s.isEmpty())
//         return true;
//         int len1 = s.length();
//         int len2 = t.length();
//         int  i = 0;
//         int  j = 0; 
//         while(j < len2)
//         {
            
//             if(s.charAt(i) == t.charAt(j))
//             {
//                 i++;
//                 j++;
//             }
//             else
//             j++;
            
//         }
    
//     return i == len1;
//     }
// }
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int len1 = s.length();
        int len2 = t.length();
        int i = 0; // pointer for string s
        int j = 0; // pointer for string t

        while (j < len2) {
            if (i < len1 && s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == len1; // check if all characters of s were found in t in order
    }
}