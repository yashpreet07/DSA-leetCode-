// Your Code Full of Error.
// Didn't Know Cirrcular array and its Wrap Around.
// class Solution {
//     public int[] decrypt(int[] code, int k) {
//         int n = code.length;
//         int decode[] = new int [n];
//         if(k > 0)
//         {
//             int i = 0;
//             while(i < n - 1)
//             {   int j = i + k;
//                 decode[i] = sum(i,j);
//                 i++;
//             }
                
//         }
//         if(k < 0)
//         {
//             int i = n - 1;
//             while(i < n - 1)
//             {   int j = i + k;
//                 decode[i] = sum(i,j);
//                 i++;
//             }
//         }
//         if(k == 0) This one is just pathetic!!!
//         {
//             int i = 0;
//             while(i < n - 1)
//             {
//                 decode[i] = 0;
//                 i++;
//             }
//         }
//         return decode;
//     }
//     public int sum(int sI,int eI)
//     {   int sum = 0;
//         for(int ind = sI;ind < eI;ind++)
//         {
//             sum += code[ind];
//         }
//     }
// }

// class Solution {
//     public int[] decrypt(int[] code, int k) {
//         int n = code.length;
//         int[] decode = new int[n];

//         if (k == 0) {
//             // If k is 0, all elements in decode are 0
//             return decode; // Initialized to zero by default
//         }

//         for (int i = 0; i < n; i++) {
//             int sum = 0;

//             // Calculate the range based on the value of k
//             if (k > 0) {
//                 for (int j = 1; j <= k; j++) {
//                     sum += code[(i + j) % n]; // Wrap around using modulo
//                 }
//             } else if (k < 0) {
//                 for (int j = -1; j >= k; j--) {
//                     sum += code[(i + j + n) % n]; // Wrap around using modulo
//                 }
//             }

//             decode[i] = sum;
//         }

//         return decode;
//     }
// }

// Now Using Sliding Window to Optimize this code.
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] decode = new int[n];
        
        if (k == 0) {
            return decode; // All elements are 0 if k == 0
        }
        
        int start, end, windowSum = 0;
        if (k > 0) {
            start = 1;
            end = k;
        } else {
            start = n + k; // Equivalent to n + k for negative k
            end = n - 1;
        }

        // Compute the initial window sum
        for (int i = start; i <= end; i++) {
            windowSum += code[i % n];
        }

        // Slide the window across the array
        for (int i = 0; i < n; i++) {
            decode[i] = windowSum;

            // Adjust the sliding window
            windowSum -= code[start % n];
            start++;
            end++;
            windowSum += code[end % n];
        }

        return decode;
    }
}
