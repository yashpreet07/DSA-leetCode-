class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int freq1[] = new int[26];
        for(char ch : s.toCharArray()){
            freq1[ch - 'a']++;
        }
        for(char ch : t.toCharArray()){
            freq1[ch - 'a']--;
            if(freq1[ch - 'a'] < 0)
                return false;
        }

        return true;
    }
}