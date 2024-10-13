// class Solution {
//     public String[] sortPeople(String[] names, int[] heights) {
//         Map<Integer,String> mp = new HashMap<>();
//         int i = 0;
//         while(i < names.length)
//         {
//             mp.put(heights[i],names[i]);
//             i++;
//         }
//         Arrays.sort(heights);
//         i = names.length - 1;
//         int j = 0;
//         while(i >= 0)
//         {
//             names[i] = mp.get(heights[j]);
//             i--;
//             j++;
//         }
//     return names;
//     }
// }
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // Create an array of indices
        Integer[] indices = new Integer[names.length];
        for (int i = 0; i < names.length; i++) {
            indices[i] = i; // Store the index of each person
        }

        // Sort the indices based on the heights in descending order
        Arrays.sort(indices, (a, b) -> Integer.compare(heights[b], heights[a]));

        // Create the result array and populate it with sorted names
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            result[i] = names[indices[i]];
        }

        return result;
    }
}