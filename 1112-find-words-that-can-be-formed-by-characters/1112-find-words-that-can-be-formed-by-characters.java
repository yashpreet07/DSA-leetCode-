// // Your Code With Failed Test Cases.
// class Solution {
//     public int countCharacters(String[] words, String chars) {
//         int outerCount = 0;
//         for(int i = 0; i < words.length; i++)
//         {   int innerCount = 0;
//             String s = words[i];
//             int len = s.length();
//             for(char ch : s.toCharArray())
//             {
//                 if(chars.indexOf(ch) != -1)
//                     innerCount++;
//             }
//             if(innerCount == len)
//                 outerCount += innerCount;
//         }
//     return outerCount;
//     }
// }
/*
The current implementation only checks whether a character exists in chars, but it doesn’t handle the frequency of characters. For example, if a word contains a letter more times than it appears in chars, it will still count it as valid, which is incorrect.

You need to count the frequency of each character in chars and each word, and ensure that each character in the word appears in chars with equal or greater frequency.

 */
// class Solution {
//     public int countCharacters(String[] words, String chars) {
//         int outerCount = 0;

//         // Create a frequency map for characters in chars
//         HashMap<Character, Integer> charCount = new HashMap<>();
//         for (char ch : chars.toCharArray()) {
//             charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
//         }

//         for (String word : words) {
//             HashMap<Character, Integer> wordCount = new HashMap<>();

//             // Create a frequency map for the current word
//             for (char ch : word.toCharArray()) {
//                 wordCount.put(ch, wordCount.getOrDefault(ch, 0) + 1);
//             }

//             // Check if the word can be formed by chars
//             boolean canForm = true;
//             for (char ch : word.toCharArray()) {
//                 if (wordCount.get(ch) > charCount.getOrDefault(ch, 0)) {
//                     canForm = false;
//                     break;
//                 }
//             }

//             if (canForm) {
//                 outerCount += word.length(); // Add the length of the valid word
//             }
//         }

//         return outerCount;
//     }
// }

// Further Optimization Using Freq. Array!!!
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCount = new int[26]; // Array to store frequency of chars
        for (char ch : chars.toCharArray()) {
            charCount[ch - 'a']++;
        }

        int totalLength = 0;

        for (String word : words) {
            int[] wordCount = new int[26]; // Array to store frequency of the current word
            for (char ch : word.toCharArray()) {
                wordCount[ch - 'a']++;
            }

            boolean canForm = true;
            for (int i = 0; i < 26; i++) {
                if (wordCount[i] > charCount[i]) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }
}