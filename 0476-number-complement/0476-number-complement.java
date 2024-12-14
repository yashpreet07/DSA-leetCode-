// Wrong mask logic!!
// class Solution {
//     public int findComplement(int num) {
//         int mask = 0;
//         int i = 0 ;
//         while(i < 32)
//         {
//             mask = 1 << i;
//             i++;
//         }
        
//         num = (int)(num ^ mask);
//         return num;
//     }
// }


class Solution {
    public int findComplement(int num) {
        // Find the mask: All bits to 1 up to the MSB of num
        int mask = 0;
        int temp = num;
        while (temp != 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }
        
        // Flip the bits of num using the mask
        return num ^ mask;
    }
}