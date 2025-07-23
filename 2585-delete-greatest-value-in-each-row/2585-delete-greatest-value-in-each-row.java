class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Sort each row
        for (int[] row : grid) {
            Arrays.sort(row);
        }

        int totalSum = 0;
        // Step 2: Iterate column-wise from last to first
        for (int col = n - 1; col >= 0; col--) {
            int maxVal = 0;
            for (int row = 0; row < m; row++) {
                maxVal = Math.max(maxVal, grid[row][col]);
            }
            totalSum += maxVal;
        }

        return totalSum;
    }
}