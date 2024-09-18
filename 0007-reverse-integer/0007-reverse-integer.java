class Solution {
    public int reverse(int x) {
        int num = 0;
        
        while (x != 0) {
            int lastDigit = x % 10;
            // Check for overflow before multiplying and adding
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0; // Positive overflow
            }
            if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0; // Negative overflow
            }
            num = num * 10 + lastDigit;
            x /= 10;
        }
        
        return num;
    }
}
// your solution.
//  class Solution {
//     public int reverse(int x) {
//         int num=0;
//         int n=x;
//         while(x!=0)
//         {
//             num=num*10+x%10;
//             x/=10;
//         }
//    return n>0 ? num : -(num);
//      }
// }



// if(x<0)
        //     x=-x;
        // String str=String.valueOf(x);
        // int len=str.lenght()-1;
        // String s="";
        // for(char ch : s.toCharArray())
        // {
        //     s+=ch;
        // }
