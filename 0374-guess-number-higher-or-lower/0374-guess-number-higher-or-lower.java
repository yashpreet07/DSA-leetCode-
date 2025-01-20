/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
// Use brackets in if else!!!
// public class Solution extends GuessGame {
//     public int guessNumber(int n) {
//         int lo = 1;
//         int hi = n;
//         int ans = 0;
//         while(lo <= hi){
//             int mid = (lo + hi) / 2;
//             if(guess(mid) == 0)
//                 ans = mid;
//             else if(guess(mid) == -1)
//                     hi = mid - 1;
//                     else
//                     lo = mid + 1;
//         }
//     return ans;
//     }
// }

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // Avoid overflow by calculating mid this way
            int result = guess(mid);

            if (result == 0) {
                return mid; // Number is found
            } else if (result == -1) {
                hi = mid - 1; // Target is smaller
            } else {
                lo = mid + 1; // Target is larger
            }
        }
        
        return -1; // This should never be reached if input is valid
    }
}