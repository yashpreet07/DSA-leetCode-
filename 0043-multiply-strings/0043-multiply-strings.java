import java.math.BigInteger;

class Solution {
    public String multiply(String num1, String num2) {
        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger result = a.multiply(b);
        return result.toString();
    }
}



// class Solution {
//     public String multiply(String num1, String num2) {
//         long a = Integer.valueOf(num1);
//         long b = Integer.valueOf(num2);
//         String c = String.valueOf(a * b);
//         return c;
//     }
// }