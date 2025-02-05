class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        
        int n = s1.length();
        int count = 0;
        int firstMismatch = -1, secondMismatch = -1;

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count == 1) firstMismatch = i;
                else if (count == 2) secondMismatch = i;
                else return false; // More than 2 mismatches, can't be one swap away
            }
        }

        if (count != 2) return false;

        // Check if swapping s1[firstMismatch] and s1[secondMismatch] makes them equal
        return s1.charAt(firstMismatch) == s2.charAt(secondMismatch) &&
               s1.charAt(secondMismatch) == s2.charAt(firstMismatch);
    }
}
// Wrong Answer by your code!!
// class Solution {
//     public boolean isFreqSame(String str1, String str2) {
//         int freq1[] = new int[26];
//         for (char ch1 : str1.toCharArray()) {
//             freq1[ch1 - 'a'] += 1;
//         }
//         int freq2[] = new int[26];
//         for (char ch2 : str2.toCharArray()) {
//             freq2[ch2 - 'a'] += 1;
//         }
//         for (int i = 0; i < 26; i++) {
//             if (freq1[i] != 0 && freq2[i] != 0) {
//                 if (freq1[i] != freq2[i])
//                     return false;
//             }
//         }
//         return true;
//     }

//     public boolean areAlmostEqual(String s1, String s2) {
//         if (s1.equals(s2))
//             return true;
//         int count = s1.length(), n = s1.length();
//         for (int i = 0; i < n; i++) {
//             if (s1.charAt(i) == s2.charAt(i))
//                 count--;
//         }
//         if (count > n - 2)
//             return false;
//         else {
//             if (isFreqSame(s1, s2))
//                 return true;
//             else
//                 return false;
//         }
//     }
// }