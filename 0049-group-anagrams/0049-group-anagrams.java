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
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] freq = new int[26];
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }
            
            // Build the frequency pattern string with a delimiter
            StringBuilder freqPattern = new StringBuilder();
            for (int charFreq : freq) {
                freqPattern.append(charFreq).append("#"); // Adding '#' as a delimiter
            }
            
            String pattern = freqPattern.toString();
            if (!map.containsKey(pattern)) {
                map.put(pattern, new ArrayList<>());
            }
            map.get(pattern).add(str);
        }
        return new ArrayList<>(map.values());
    }
}