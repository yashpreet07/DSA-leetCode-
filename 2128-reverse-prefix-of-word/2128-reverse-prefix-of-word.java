class Solution {
    public String reversePrefix(String word, char ch) {
        int ind = word.indexOf(ch);
        if (ind == -1) return word;
        StringBuilder sb = new StringBuilder(word.substring(0, ind + 1));
        sb.reverse();
        sb.append(word.substring(ind + 1));

        return sb.toString();
    }
}


        // Stack<Character> s = new Stack<>();
        // for(int i = 0;i <= word.indexOf(ch);i++){
        //     s.push(word.charAt(i));
        // }
        // String str = new String("");
        // for(int i = 0;i <= word.indexOf(ch);i++){
        //     str.charAt(i) = s.pop();
        // }
        // str =+ word.substring(i + 1);
        // return str;