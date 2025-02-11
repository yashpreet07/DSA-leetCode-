class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        int n = part.length();
        int i = 0;
        while(i < len && sb.toString().contains(part)){
            if((sb.substring(i,i + n)).toString().equals(part)){
                sb.delete(i,i + n);
                i = -1;
            }
            i++;
        }
        return sb.toString();
    }
}