// class Solution {
//     public List<List<Integer>> minimumAbsDifference(int[] arr) {
//         List<List<Integer>> lst = new ArrayList<>();
//         Arrays.sort(arr);
//         int minAbsDiff = Math.abs(arr[1] - arr[0]);
//         int i = 0;
//         int j = 1;
//         while(j < arr.length)
//         {
//            List<Integer> l = new ArrayList<>();
//            if(arr[j] - arr[i] == minAbsDiff)
//            {
//             l.add(arr[i]);
//             l.add(arr[j]);
//             lst.add(l);
//            }
//         i++;
//         j++;
//         }
// return lst;
//     }
// }
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> lst = new ArrayList<>();
        Arrays.sort(arr);
        
        // Start by assuming the minimum difference is between the first two elements
        int minAbsDiff = arr[1] - arr[0];
        
        // Find the minimum absolute difference between adjacent pairs
        for (int i = 1; i < arr.length; i++) {
            minAbsDiff = Math.min(minAbsDiff, arr[i] - arr[i - 1]);
        }
        
        // Collect pairs that have this minimum absolute difference
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minAbsDiff) {
                List<Integer> l = new ArrayList<>();
                l.add(arr[i - 1]);
                l.add(arr[i]);
                lst.add(l);
            }
        }
        
        return lst;
    }
}