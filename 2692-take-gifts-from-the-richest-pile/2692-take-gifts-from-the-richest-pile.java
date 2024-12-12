class Solution {
    public long pickGifts(int[] gifts, int k) {
        for (int i = 0; i < k; i++) {
            // Find the index of the largest gift pile
            int maxIndex = 0;
            for (int j = 1; j < gifts.length; j++) {
                if (gifts[j] > gifts[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Reduce the largest pile
            gifts[maxIndex] = (int) Math.sqrt(gifts[maxIndex]);
        }

        // Calculate the total sum of remaining gifts
        long sum = 0;
        for (int gift : gifts) {
            sum += gift;
        }
        return sum;
    }
}

// class Solution {
//     public long pickGifts(int[] gifts, int k) {
//         Arrays.sort(gifts);
//         for(int i = gifts.length - 1;i >= 0 ;i--)
//         {
//             if(k > 0)
//             {
//                 gifts[i] =(int)Math.floor(Math.sqrt(gifts[i])) ;
//                 k--;
//             }
//             else
//             break;
//         }
//         int sum =0;
//         for(int i : gifts)
//         sum += i;
//     return sum;
//     }
// }