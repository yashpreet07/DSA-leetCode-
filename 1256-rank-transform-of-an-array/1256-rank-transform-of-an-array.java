// Your Code
// class Solution {
//     public int[] arrayRankTransform(int[] arr) {
//         for(int i = 0; i < arr.length; i++)
//         {   int count = 1;
//             for(int j = 0; j < arr.length; j++)
//             {
//                 if(arr[i] > arr[j])
//                     count++;
//             }
//             arr[i] =count;
//         }
//     return arr;
//     }
// }
/*
The logic in your code is incorrect because it doesn’t handle ties (duplicate elements) properly. When elements have the same value, they should have the same rank, but your current approach does not account for that. Instead, it gives each element a rank based on how many elements are smaller than it, without considering ties.

Here’s a correct approach:

	1.	Sort the unique elements of the array.
	2.	Assign ranks to the unique elements.
	3.	Replace the original elements with their ranks.
*/
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Use a HashMap to store the rank of each unique element.
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        
        // Assign ranks to the elements in sortedArr.
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        // Replace elements in the original array with their ranks.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }
}