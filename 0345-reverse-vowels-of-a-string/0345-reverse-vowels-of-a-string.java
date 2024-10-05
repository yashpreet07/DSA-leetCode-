// class Solution {
//     public boolean isVowel(char ltr)
//     {   
//         String vowel = "AEIOUaeiou";
//         // return vowel.indexOf(ltr) !=-1 ? true : false; Instead of This Just do
//         return vowel.indexOf(ltr) != -1;
//     }
//     public String reverseVowels(String s) {
//         char []ch = s.toCharArray();
//         int i = 0;
//         int j = s.length()-1;
//         while(i < j)
//         {
//             if(isVowel(ch[i]) && isVowel(ch[j]))
//             {
//                 char temp = ch[i];
//                 ch[i] = ch[j];
//                 ch[j] = temp;
//                 i++;
//                 j--;
//             }
//             if(!isVowel(ch[i]))
//                 i++;
//             if(!isVowel(ch[j]))
//                 j--;
//         }
//       return String.valueOf(ch);
//     }
// }

class Solution {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        
        while (start < end) {
            // Move start pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }
            
            // Move end pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }
            
            // Swap the vowels
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            
            // Move the pointers towards each other
            start++;
            end--;
        }
        
        String answer = new String(word);
        return answer;
    }
}