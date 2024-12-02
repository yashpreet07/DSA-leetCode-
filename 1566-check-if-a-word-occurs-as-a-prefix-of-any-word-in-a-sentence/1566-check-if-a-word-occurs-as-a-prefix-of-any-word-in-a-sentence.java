// class Solution {
//     public int isPrefixOfWord(String sentence, String searchWord) {
//         int len = sentence.length();
//         String wrd[] = new String[len];
//         // This creates an array of String references, but all elements are initialized to null.
//         int j = 0;
//         // This Entire Forloop is manual parsing for converting a sentence into words
//         for (int i = 0; i < len; i++) {
//             if (sentence.charAt(i) != ' ')
//                 wrd[j] += sentence.charAt(i);
//                 // This translates to wrd[j] = wrd[j] + sentence.charAt(i);. Since wrd[j] is null, it results in a NullPointerException.
//             else
//                 j++;
//         }
//         int ind = 0;
//         for (int i = 0; i < wrd.length; i++) {
//             if (wrd[i].contains(searchWord)) {
//                 ind = i;
//                 break;
//             }
//         }
//         return ind != 0 ? ind + 1 : -1;
//     }
// }
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" "); // Split the sentence into words
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) { // Check if the word starts with searchWord
                return i + 1; // Return 1-based index
            }
        }
        return -1; // Return -1 if no match is found
    }
}