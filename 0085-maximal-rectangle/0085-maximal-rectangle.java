class Solution {
    public int MAH(int[] hgt) {
        int maxArea = 0;
        int n = hgt.length;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : hgt[i];
            while (!s.isEmpty() && hgt[s.peek()] > currHeight) {
                int h = hgt[s.pop()];
                int left = (s.isEmpty()) ? -1 : s.peek();
                int w = i - left - 1;
                maxArea = Math.max(maxArea,w * h);
            }
            s.push(i);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int height[] = new int[n];
        int maxArea = 0;
        for(int j = 0;j < n;j++){
            height[j] = matrix[0][j] - '0';
        }
        maxArea = MAH(height);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {  // ✅ Compare directly as character
                    height[j] = 0;
                } else {
                    height[j] += (matrix[i][j] - '0');  // ✅ Convert char '1' to int 1
                }
            }
        maxArea = Math.max(maxArea,MAH(height));
        }
    return maxArea;
    }
}