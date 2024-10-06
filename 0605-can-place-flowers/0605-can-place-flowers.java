// class Solution {
//     public boolean canPlaceFlowers(int[] flowerbed, int n) {
//         int count = 0;
//         for (int i = 0; i < flowerbed.length; i++) {
//             if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
//                 count++;
//                 flowerbed[i] = 1;
//             }
//             if (i == flowerbed.length - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0)
//                 count++;
//             if (i != 0 && i != flowerbed.length - 1) {
//                 if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
//                     count++;
//                     flowerbed[i] = 1;
//                 }
//             }

//         }
//         return n <= count ? true : false;
//     }
// }


class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                // Check the previous and next positions
                boolean emptyPrev = (i == 0) || (flowerbed[i - 1] == 0);  // If i is 0, treat it as valid
                boolean emptyNext = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);  // If i is last, treat it as valid
                
                if (emptyPrev && emptyNext) {
                    flowerbed[i] = 1;  // Place a flower
                    count++;
                }
            }
        }
        return count >= n;
    }
}