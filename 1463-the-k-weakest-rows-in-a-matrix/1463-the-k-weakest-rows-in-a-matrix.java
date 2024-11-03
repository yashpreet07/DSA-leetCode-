// YOur Code Incomplete!!!
// class Solution {
//     public int[] kWeakestRows(int[][] mat, int k) {
//         int m = mat.length;
//         int n = mat[0].length;
//         int arr = new arr[m];
//         for(int i = 0;i < m;i++)
//         {   int sol = 0;
//             for(int j = 0;j < n;j++)
//             {
//                 if(mat[i][j] == 1)
//                     sol++;
//             }
//             arr[i] = sol;
//         }
//         for(int x = 0;x < arr.length;x++)
//         {

//         }
//     }
// }

// Withour using Priority Queues
// class Solution {
//     public int[] kWeakestRows(int[][] mat, int k) {
//         int m = mat.length;
//         int[] arr = new int[m];
        
//         // Count the number of soldiers (1s) in each row
//         for(int i = 0; i < m; i++) {
//             int sol = 0;
//             for(int j = 0; j < mat[i].length; j++) {
//                 if(mat[i][j] == 1) sol++;
//             }
//             arr[i] = sol;
//         }
        
//         // Array to store indices and counts
//         int[][] rowStrength = new int[m][2];
//         for(int i = 0; i < m; i++) {
//             rowStrength[i][0] = arr[i]; // Soldier count
//             rowStrength[i][1] = i;      // Row index
//         }
        
//         // Sort by soldier count, then by index
//         Arrays.sort(rowStrength, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
//         // Collect indices of the k weakest rows
//         int[] result = new int[k];
//         for(int i = 0; i < k; i++) {
//             result[i] = rowStrength[i][1];
//         }
        
//         return result;
//     }
// }
import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );
        
        for (int i = 0; i < m; i++) {
            int soldiers = countSoldiers(mat[i]);
            pq.offer(new int[]{soldiers, i});
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[1];
        }
        
        return result;
    }

    private int countSoldiers(int[] row) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}