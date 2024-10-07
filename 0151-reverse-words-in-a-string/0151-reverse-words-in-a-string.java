/*This is very easy but you made it very difficult for yourself because you thought in wrong direction ie; came up with wrong logic in the first place then tried to implement that !!!
Instead of Simply forming String from the right you thought in this question we need to swap first wrd with last and so on which made this code horrendous.

And whenever you write such horrendous code that also means there's gap in knowledge somewhere,
like in this you where not aware of "regular expression" (or regex)
*/
// class Solution {
//     public String reverseWords(String s) {
//        s=s.trim();
//        int l = s.length();
//        StringBuilder sb = new StringBuilder();
//        for(int k = 0;k < l; k++ )
//        {
//         if(s.charAt(k) != ' ')
//             sb.append(s.charAt(k));
//         else
//         {   sb.append(" ");
//             while(s.charAt(k) == ' ')
//                 k++;
//         }
//        }
//        int i = 0;
//        int j = sb.length()-1;
//        int startIndBegWrd = i;
//        int lastIndEndWrd = j;
//        while(i < j)
//        {
//         if(sb.charAt(i) == ' ' && sb.charAt(j) == ' ')
//         {
//             String temp = s.substring(startIndBegWrd,i);
//             sb.replace(startIndBegWrd,i,sb.substring(j,lastIndEndWrd));
//             sb.replace(j-1,lastIndEndWrd,temp);
//             startIndBegWrd = i + 1;
//             lastIndEndWrd = j - 1;
//         }
//         if(sb.charAt(i) != ' ')
//              i++;
//         if(sb.charAt(j) != ' ')
//              j--;
//        }
// return sb.toString();
//     }
// }
class Solution {
    public String reverseWords(String s) {
        // Trim any leading or trailing spaces and split by multiple spaces
        String[] words = s.trim().split("\\s+");
        
        // Reverse the words in the array
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");  // Add space between words
            }
        }
        
        return result.toString();
    }
}