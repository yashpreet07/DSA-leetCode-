class Solution {
    public boolean canWinNim(int n) {
        // If n is divisible by 4, you will lose
        return n % 4 != 0;
    }
}