public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        
        // Process both strings from end to beginning
        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            
            // Calculate sum of the two digits and carry
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
            
            i--;
            j--;
        }
        
        // Since we append the result in reverse order, we reverse it before returning
        return result.reverse().toString();
    }
}













// class Solution {
//     public String addStrings(String num1, String num2) {
//         int m = num1.length();
//         int n = num2.length();
//         int []res = new res[n];
//         for(int i = m-1; i > 0;i --)
//         {
//             for(int j=n-1; j > 0;j--)
//             {
//                 int add = num2.charAt(j) + num1.charAt(i);
//                 if(add > 9)
//                 {
//                     res[] = add % 10;
//                 }
//             }
//         }
//     }
// }