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
 class Solution {
    public int divisorSubstrings(int num, int k) {
        int i = 0;
        int count = 0;
        String str = String.valueOf(num);
        int len = str.length();
        
        while (i + k <= len) {
            int n = Integer.valueOf(str.substring(i, i + k));  // Get k-length substring as integer
            
            // Check if n is a non-zero divisor of num
            if (n != 0 && num % n == 0) 
                count++;
            
            i++;  // Move the window
        }
        return count;  // Return the count of valid substrings
    }
}