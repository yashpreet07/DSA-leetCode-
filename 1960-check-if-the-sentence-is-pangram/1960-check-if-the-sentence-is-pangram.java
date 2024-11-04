// Your Code beats 86%
class Solution {
    public boolean checkIfPangram(String sentence) {
            if (sentence.length() < 26) return false; // added later Early return if length is less than 26
        int freq[] = new int[26];
        for(char ch : sentence.toCharArray())
            freq[ch - 'a']++;
        for(int i : freq)
        {
            if(i == 0)
                return false;
        }
    return true;
    }
}

/*
this code can be optimized. Here are a few improvements:

	1.	Use a HashSet: Instead of using an integer array freq to track character occurrences, we can use a HashSet to store the unique characters. This reduces space complexity and helps avoid unnecessary loops.
	2.	Early Return: If the sentence has fewer than 26 characters, we can return false immediately, as it cannot be a pangram.
	3.	Short-circuiting: As soon as we have all 26 letters in the set, we can return true without further processing.
*/
// class Solution {
//     public boolean checkIfPangram(String sentence) {
//         if (sentence.length() < 26) return false; // Early return if length is less than 26
        
//         Set<Character> uniqueChars = new HashSet<>();
//         for (char ch : sentence.toCharArray()) {
//             uniqueChars.add(ch);
//             if (uniqueChars.size() == 26) return true; // Early return if all letters are found
            /*
            The reason for keeping if (uniqueChars.size() == 26) return true; inside the loop is to allow early termination.

When the code encounters all 26 unique letters, it immediately stops processing and returns true, rather than looping through the rest of the string. This check reduces unnecessary iterations, especially for longer strings where all letters are found early on.

If you move this line outside the loop, the program will continue iterating through every character, even after finding all 26 letters. This would make the solution less efficient, particularly for longer strings where we could exit early.

However, this approach does perform the check repeatedly inside the loop. If you’re concerned about this, you can make the code cleaner by moving the check to a separate method that reduces redundancy in logic, while keeping the early return:
            */
//         }
        
//         return false;
//     }
// }

