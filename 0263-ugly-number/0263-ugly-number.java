class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false; // Ugly numbers must be positive
        
        // Divide n by 2, 3, and 5 as long as possible
        for (int factor : new int[]{2, 3, 5}) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        
        // If the remaining number is 1, it is ugly
        return n == 1;
    }
}