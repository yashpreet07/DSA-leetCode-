// class Solution {
//     public int divisorSubstrings(int num, int k) {
//         int i=0;
//         int j=k;
//         int count=0;
//         String str= String.valueOf(num);
//         int len=str.length();
//         while(j<=len){
//             int n=Integer.valueOf(str.substring(i,j));
//             // if(j==len) Completely useless to add special case handling of lst substring.
//             //  n=(Integer.valueOf(str.substring(i)));
//             if(n!=0 && num%n==0)
//                 count++;
//             i++;
//             j++;
//         }
//    return count;
//     }
// }


// Optimized Code
//  class Solution {
//     public int divisorSubstrings(int num, int k) {
//         int i = 0;
//         int count = 0;
//         String str = String.valueOf(num);
//         int len = str.length();
        
//         while (i + k <= len) {
//             int n = Integer.valueOf(str.substring(i, i + k));  // Get k-length substring as integer
            
//             // Check if n is a non-zero divisor of num
//             if (n != 0 && num % n == 0) 
//                 count++;
            
//             i++;  // Move the window
//         }
//         return count;  // Return the count of valid substrings
//     }
// }


class Solution {
    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int count = 0;
        int len = str.length();
        
        // First k-length substring as an integer
        int currentNum = Integer.parseInt(str.substring(0, k));
        
        // Check if the first k-length substring is a divisor
        if (currentNum != 0 && num % currentNum == 0) {
            count++;
        }
        
        // Sliding window through the rest of the string
        for (int i = 1; i <= len - k; i++) {
            // Calculate the next number in the window by adjusting the digits
            currentNum = currentNum % (int) Math.pow(10, k - 1); // Remove the leading digit
            currentNum = currentNum * 10 + (str.charAt(i + k - 1) - '0'); // Add the trailing digit
            
            if (currentNum != 0 && num % currentNum == 0) {
                count++;
            }
        }
        
        return count;
    }
}