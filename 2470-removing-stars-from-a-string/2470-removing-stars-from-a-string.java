class Solution {
    public String removeStars(String str) {
        Stack<Character> s = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == '*' && !s.isEmpty())
                s.pop();
            else s.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }
}