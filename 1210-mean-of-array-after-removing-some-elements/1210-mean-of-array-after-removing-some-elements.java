// class Solution {
//     public double trimMean(int[] arr) {
//         Arrays.sort(arr);
//         int rm = (5/100) * arr.length;
//         double sum = 0.0;
//         for(int i = rm;i < arr.length - rm;i++)
//             sum += arr[i];
//         return sum / rm;
//     }
// }


import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int rm = (5 * arr.length) / 100;
        double sum = 0.0;
        for (int i = rm; i < arr.length - rm; i++) {
            sum += arr[i];
        }
        return sum / (arr.length - 2 * rm);
    }
}