// The Optimized code.
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Move left pointer to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Move right pointer to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // Compare the characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Your code 
// class Solution {
//     public boolean isPalindrome(String s) {
//         s = s.toLowerCase();
//         String rStr = removeNonAlphaNum(s);
//         int i = 0;
//         int j = rStr.length() - 1;
//         while (j >= i) {
//             if (rStr.charAt(i) != rStr.charAt(j))
//                 return false;
//             i++;
//             j--;
//         }
//         return true;
//     }

//  public String removeNonAlphaNum(String str) {
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < str.length(); i++) {
//             char ch = str.charAt(i);
//             // Only add if the character is a letter or a digit
//             if (Character.isLetterOrDigit(ch)) {
//                 sb.append(ch);
//             }
//         }
//         return sb.toString();
//     }
// }