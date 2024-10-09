public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // If str1 + str2 is not equal to str2 + str1, there is no common divisor string
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // Use the greatest common divisor (GCD) of the lengths of the two strings
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);  // Return the GCD string
    }

    // Helper method to calculate the GCD of two numbers using Euclidean algorithm
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}