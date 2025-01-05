public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] delta = new int[n + 1]; // Difference array to track shifts

        // Record the shifts in the delta array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            delta[start] += (direction == 1) ? 1 : -1; // Add shift at start
            if (end + 1 < n) {
                delta[end + 1] -= (direction == 1) ? 1 : -1; // Subtract shift beyond end
            }
        }

        // Compute cumulative shifts and build the result
        StringBuilder result = new StringBuilder();
        int currentShift = 0;

        for (int i = 0; i < n; i++) {
            currentShift += delta[i]; // Apply cumulative shift
            int shiftedIndex = ((s.charAt(i) - 'a' + currentShift) % 26 + 26) % 26; // Handle modulo
            result.append((char) (shiftedIndex + 'a')); // Append shifted character
        }

        return result.toString();
    }
}