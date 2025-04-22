// class Solution {
//     public boolean isPerfectSquare(int num) {
//         for(int i = 2;i <= num / 2;i++){
//             if(i * i == num)
//                 return true;
//         }
//         return  num == 1 ? true : false;
//     }
// }


// Bs on ans:
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        long left = 2, right = num / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long guess = mid * mid;

            if (guess == num) {
                return true;
            } else if (guess < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}