// Your Wrong code!!! 
// couldn't handel wrap Around Logic of a + 1 ----> z.
// class Solution {
//     public boolean canMakeSubsequence(String str1, String str2) {
//         int i = 0;
//         int j = 0;
//         int len = str1.length();
        // int count = 0; When j pointer was there this really useless!!!
//         int x = 1;
//         while(i < len)
//         {   if(str1.charAt(i) == 'z')
//                 x = -25;
//             if(str2.charAt(j) == str1.charAt(i) || str2.charAt(j) == (str1.charAt(i) + x))
//                 {
//                     count++;
//                     i++;
//                     j++;
//                 }
//             else
//             i++;
//         }
//         return count == str2.length();
//     }  
// }
// class Solution {
//     public boolean canMakeSubsequence(String str1, String str2) {
//         int i = 0;
//         int j = 0;

//         while (i < str1.length() && j < str2.length()) {
//             char currentChar = str1.charAt(i);
//             char nextChar = (currentChar == 'z') ? 'a' : (char) (currentChar + 1);
            
//             if (str2.charAt(j) == currentChar || str2.charAt(j) == nextChar) {
//                 j++;
//             }
//             i++;
//         }

//         return j == str2.length();
//     }
// }
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int ptr1 = 0, ptr2 = 0;
        int n1 = str1.length(), n2 = str2.length();

        while (ptr1 < n1 && ptr2 < n2) {
            char sch = str1.charAt(ptr1);
            char tch = str2.charAt(ptr2);

            if (sch == tch || sch + 1 == tch || sch - 25 == tch) {
                ptr2++;
            }
            ptr1++;
        }

        return ptr2 == n2;
    }
}