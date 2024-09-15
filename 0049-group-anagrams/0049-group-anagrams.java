// Error code.
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map=new HashMap<>();
//         for(String str : strs)
//         {
//             int freq[]=new int[26];
//             for(char ch:str.toCharArray())
//             freq[ch-'a'] ++;
            
//             String freqPattern="";
//             for(int charFreq : freq)
//             freqPattern +=(charFreq + "");

//             if(!map.containsKey(freqPattern))
//                 map.put(freqPattern, new ArrayList<>());
//             map.get(freqPattern).add(str);
//         }
//     return new ArrayList <>(map.values());
//     }
// }


/*
The error in your code lies in how you are constructing the freqPattern string. In particular, concatenating the frequencies as strings directly could lead to ambiguity. For example, if you have frequencies [1, 12] for two letters, concatenating them would produce 112, which is indistinguishable from the frequency pattern [11, 2].

To fix this, use a delimiter between the character frequencies to avoid ambiguity. Here’s the corrected version of your code:
*/
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map = new HashMap<>();
//         for (String str : strs) {
//             int[] freq = new int[26];
//             for (char ch : str.toCharArray()) {
//                 freq[ch - 'a']++;
//             }
            
//             // Build the frequency pattern string with a delimiter
//             StringBuilder freqPattern = new StringBuilder();
//             for (int charFreq : freq) {
//                 freqPattern.append(charFreq).append("#"); // Adding '#' as a delimiter
//             }
            
//             String pattern = freqPattern.toString();
//             if (!map.containsKey(pattern)) {
//                 map.put(pattern, new ArrayList<>());
//             }
//             map.get(pattern).add(str);
//         }
//         return new ArrayList<>(map.values());
//     }
// }
// More optimzed code
// You can optimize the solution by avoiding frequency array manipulation and directly sorting the characters of each string. Sorting ensures that all anagrams produce the same sorted string, which can be used as a key in the map. This approach simplifies the logic and makes it faster in practice for moderate input sizes.
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> map = new HashMap<>();
        
//         for (String str : strs) {
//             // Sort the characters of the string
//             char[] chars = str.toCharArray();
//             Arrays.sort(chars);
//             String sortedStr = new String(chars);
            
//             // Use sorted string as key
//             if (!map.containsKey(sortedStr)) {
//                 map.put(sortedStr, new ArrayList<>());
//             }
//             map.get(sortedStr).add(str);
//         }
        
//         return new ArrayList<>(map.values());
//     }
// }
/*Key Optimizations:

	1.	Sorting Strings: By sorting each string, all anagrams will produce the same sorted string, allowing us to use it as a unique key in the map.
	2.	Simpler Key Management: Instead of using frequency arrays and patterns, sorting makes it straightforward to identify anagrams, reducing potential sources of bugs and ambiguity.

Time Complexity:

	•	Sorting each string takes O(k \log k), where k is the average length of the strings.
	•	Since you do this for each of the n strings, the overall time complexity is O(n \cdot k \log k), which is efficient for most practical purposes.

This solution is generally more intuitive and has good performance for typical input si
*/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            // Frequency array for 26 lowercase letters
            int[] freq = new int[26];
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }
            
            // Create a unique string key from the frequency array
            StringBuilder key = new StringBuilder();
            for (int count : freq) {
                key.append(count).append('#'); // Use '#' as a delimiter between counts
            }
            
            String keyStr = key.toString();
            map.computeIfAbsent(keyStr, k -> new ArrayList<>()).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}