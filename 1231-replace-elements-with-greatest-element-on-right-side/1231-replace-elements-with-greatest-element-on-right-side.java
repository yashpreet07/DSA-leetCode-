// Your Code!!!
// class Solution {
//     public int[] replaceElements(int[] arr) {
//         int i = 0;
//         while(i < arr.length - 1)
//         {   int j = i + 1;
//             int maxNo = 0; 
//             while(j < arr.length)
//             {
//                 maxNo = Math.max(arr[j],maxNo);
//                 j++;
//             }
//             arr[i] = maxNo;
//             i++;
//         }
//         arr[arr.length - 1] = -1;
//         return arr;
//     }
// }
// Optimized code
class Solution {
    public int[] replaceElements(int[] arr) {
        int maxSoFar = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, temp);
        }
        return arr;
    }
}