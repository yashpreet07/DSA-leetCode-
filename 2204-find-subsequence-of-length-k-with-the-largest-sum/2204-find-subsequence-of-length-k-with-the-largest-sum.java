// Your code:
import java.util.*;
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Create a min-heap of pairs (value, index)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0]) // compare by value
        );

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll(); // keep only k largest values
            }
        }

        // Extract remaining elements from the heap
        List<int[]> topK = new ArrayList<>(minHeap);

        // Sort by original index to preserve order
        topK.sort(Comparator.comparingInt(a -> a[1]));

        // Build the result
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }

        return result;
    }
}

// class Solution {
//     public int[] maxSubsequence(int[] nums, int k) {
// PriorityQueue<Integer> minH = new PriorityQueue<>();
// int i = 0;
// while(i < nums.length){
//     minH.add(nums[i]);
//     if()
// }
//     //     Arrays.sort(nums);
//     //     int res[] = new int[k];
//     //     int i = 0;
//     //     while(i < k){
//     //         res[i] = nums[nums.length - 1 - i];
//     //         i++;
//     //     }
//     //     Arrays.sort(res);
//     //     return res;
//     }
// // }