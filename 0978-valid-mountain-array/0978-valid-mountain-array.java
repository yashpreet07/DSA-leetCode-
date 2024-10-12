// Your Error Code!!!
// class Solution {
//     public int maxIndex(int arr [])
//     {
//         int maxValue = 0;
//         int mI = 0;
//         for(int i = 0; i < arr.length; i++)
//         {
//            if(maxValue < arr[i])
//            {
//             maxValue = arr[i];
//             mI = i;
//            }
//         }
//     return mI;
//     }
//     public boolean validMountainArray(int[] arr) {
//         int count = 0;
//         int j = maxIndex(arr);
//         while(j > 0)
//         {
//             if(arr[j] > arr[j--])
//                 count++;
//         }
//         j = maxIndex(arr);
//         while(j < arr.length)
//         {
//             if(arr[j] > arr[j++])
//                 count++;
//         }
//     return count == arr.length - 1;
//     }
// }
// class Solution {
//     public int maxIndex(int arr[]) {
//         int maxValue = 0;
//         int mI = 0;
//         for (int i = 0; i < arr.length; i++) {
//             if (maxValue < arr[i]) {
//                 maxValue = arr[i];
//                 mI = i;
//             }
//         }
//         return mI;
//     }

//     public boolean validMountainArray(int[] arr) {
//         if (arr.length < 3) return false;

//         int peakIndex = maxIndex(arr);
//         if (peakIndex == 0 || peakIndex == arr.length - 1) return false;

//         // Check increasing part
//         for (int i = 0; i < peakIndex; i++) {
//             if (arr[i] >= arr[i + 1]) {
//                 return false;
//             }
//         }

//         // Check decreasing part
//         for (int i = peakIndex; i < arr.length - 1; i++) {
//             if (arr[i] <= arr[i + 1]) {
//                 return false;
//             }
//         }

//         return true;
//     }
// }

class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;

        int i = 0;

        // Climb up the mountain
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Peak can't be the first or the last element
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Climb down the mountain
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // Check if we have reached the end of the array
        return i == n - 1;
    }
}