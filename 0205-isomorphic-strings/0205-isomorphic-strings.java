// Beats only 37% solution
// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         if (s.length() != t.length()) {
//             return false;
//         }

//         Map<Character, Character> sToTMap = new HashMap<>();
//         Map<Character, Character> tToSMap = new HashMap<>();

//         for (int i = 0; i < s.length(); i++) {
//             char sChar = s.charAt(i);
//             char tChar = t.charAt(i);

//             // Check the mapping from s to t
//             if (sToTMap.containsKey(sChar)) {
//                 if (sToTMap.get(sChar) != tChar) {
//                     return false; // Inconsistent mapping
//                 }
//             } else {
//                 sToTMap.put(sChar, tChar); // Add new mapping
//             }

//             // Check the mapping from t to s (to ensure one-to-one mapping)
//             if (tToSMap.containsKey(tChar)) {
//                 if (tToSMap.get(tChar) != sChar) {
//                     return false; // Inconsistent reverse mapping
//                 }
//             } else {
//                 tToSMap.put(tChar, sChar); // Add new reverse mapping
//             }
//         }

//         return true;
//     }
// }
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Arrays to store mappings from characters of s -> t and t -> s
        int[] sMap = new int[256];
        int[] tMap = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // If there is already a mapping but it's inconsistent, return false
            if (sMap[sChar] != tMap[tChar]) {
                return false;
            }

            // Update the mapping for both s -> t and t -> s
            sMap[sChar] = i + 1; // We use `i + 1` to avoid conflict with default value 0
            tMap[tChar] = i + 1;
        }

        return true;
    }
}