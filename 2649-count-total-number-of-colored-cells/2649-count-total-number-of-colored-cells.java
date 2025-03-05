class Solution {
    public long coloredCells(int n) {
        long degTwoTerm = 2L * n * n;  // Avoid overflow by using long
        long degOneTerm = 2L * n;
        long ans = degTwoTerm - degOneTerm + 1;
        return ans;
    }
}