public class Solution {
    // you need to treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the rightmost bit and shift left in result
            result = (result << 1) | (n & 1);
            // Shift n right to process the next bit
            n >>= 1;
        }
        return result;
    }
}