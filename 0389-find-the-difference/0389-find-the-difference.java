// Your Code missed If the character exists in both s and t, but t has more occurrences of that character than s, your current solution will not detect this. For example, in the case where s = "aabb" and t = "aabbb", the additional 'b' will be missed by the indexOf() check.
// class Solution {
//     public char findTheDifference(String s, String t) {
//         for(char ch : t.toCharArray())
//         {
//             if(s.indexOf(ch) == -1)
//             return ch;
//         }
//     return 'a';}
// }
// count the frequency of each character in both strings and then compare those frequencies.
// class Solution {
//     public char findTheDifference(String s, String t) {
//         int[] charCount = new int[26];  // Array to store character counts (for lowercase letters)

//         // Count characters in string `s`
//         for (char ch : s.toCharArray()) {
//             charCount[ch - 'a']++;
//         }

//         // Subtract counts based on string `t`, find the extra character
//         for (char ch : t.toCharArray()) {
//             charCount[ch - 'a']--;
//             if (charCount[ch - 'a'] < 0) {
//                 return ch;  // This character has extra occurrences in `t`
//             }
//         }

//         return 'a';  // This line will never be reached, but is needed for compilation
//     }
// }

// The Best approach is Xor!!
class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;  // Initialize result as 0 (neutral for XOR)

        // XOR all characters in string `s`
        for (char ch : s.toCharArray()) {
            result ^= ch;
        }

        // XOR all characters in string `t`
        for (char ch : t.toCharArray()) {
            result ^= ch;
        }

        // After XOR-ing, result will hold the extra character in `t`
        return result;
    }
}