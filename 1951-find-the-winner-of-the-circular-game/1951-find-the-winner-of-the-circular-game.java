class Solution {
    public int findTheWinner(int n, int k) {
        int position = 0;
        for (int i = 2; i <= n; i++) {
            position = (position + k) % i;
        }
        return position + 1;
    }
}