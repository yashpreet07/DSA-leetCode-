// Your code Not knowing a simple function did this!!!
// class Solution {
//     public int prefixCount(String[] words, String pref) {
//         int count = 0;
//         int len = pref.length();
//         for(int i = 0;i < words.length;i++)
//         {
//             if(words[i].length() >= len)
//             {
//              String str = words[i].substring(0,len);
//                    if(str.equals(pref))
//                         count++;
//             }

//         }
//     return count;
//     }
// }
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}