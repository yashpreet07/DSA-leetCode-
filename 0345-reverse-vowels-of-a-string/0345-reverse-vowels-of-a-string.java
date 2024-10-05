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
    private final HashSet<Character> vowels = new HashSet<>();
    
    public Solution() {
        // Initialize the vowel set (for quick O(1) lookups)
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
    }

    public boolean isVowel(char ltr) {
        return vowels.contains(ltr);
    }

    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (isVowel(ch[i]) && isVowel(ch[j])) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            } else {
                if (!isVowel(ch[i])) {
                    i++;
                }
                if (!isVowel(ch[j])) {
                    j--;
                }
            }
        }
        return String.valueOf(ch);
    }
}

