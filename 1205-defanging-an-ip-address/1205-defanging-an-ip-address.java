class Solution {
    public String defangIPaddr(String add) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < add.length(); i++) {
            if (add.charAt(i) == '.') {
                sb.append("[.]");  // Append "[.]" to the StringBuilder
            } else {
                sb.append(add.charAt(i));  // Append the current character if not a dot
            }
        }
        return sb.toString();  // Convert StringBuilder to String
    }
}