import java.math.BigInteger;
class Solution {
    public String multiply(String num1, String num2) {
        // Edge case when either number is "0"
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];  // The product can be at most n + m digits.

        // Multiply each digit of num1 and num2
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];  // Add to the existing result and manage carry.

                result[i + j + 1] = sum % 10;  // Current digit
                result[i + j] += sum / 10;     // Carry to the previous position
            }
        }

        // Convert result array to string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.toString();
    }
}
// Not allowed to do this!!!
// class Solution {
//     public String multiply(String num1, String num2) {
//         BigInteger a = new BigInteger(num1);
//         BigInteger b = new BigInteger(num2);
//         BigInteger result = a.multiply(b);
//         return result.toString();
//     }
// }
// Your code
/*
 The problem arises when you multiply the two long values.

Here’s why: Even though each individual number might fit within the long range, multiplying two large long numbers can exceed the maximum value that a long can store. The maximum value of a long is 9,223,372,036,854,775,807, but multiplying two sufficiently large numbers can result in a product that exceeds this limit, causing an overflow.

For example:

	•	If a = 1,000,000,000 (1 billion) and b = 10,000,000,000 (10 billion), their product will be 10^19 or 10,000,000,000,000,000,000, which is greater than the maximum value that a long can store.

When overflow occurs, Java does not throw an exception, but the value wraps around, which can lead to incorrect results.

To handle large numbers and multiplication of large values, you should use BigInteger, which can handle arbitrarily large integers without risk of overflow. Here’s the corrected code:
 */
// class Solution {
//     public String multiply(String num1, String num2) {
//         long a = Integer.valueOf(num1);
//         long b = Integer.valueOf(num2);
//         String c = String.valueOf(a * b);
//         return c;
//     }
// }