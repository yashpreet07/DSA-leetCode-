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