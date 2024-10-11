// class Solution {
//     public int findContentChildren(int[] g, int[] s) {
//         int count = 0;
//         Map<Integer,Integer> mp = new HashMap<>();
//         int noChild = g.length;
//         for (int i = 0; i < noChild; i++)
//             mp.put(i, g[i]);
//         for (int j = 0; j<s.length; j++) {
//             noChild--;
//             if(noChild == 0)
//             break;
//             if (s[j] >= mp.get(j))
//                 count++;
//         }
//         return count;
//     }
// }

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort both the greed factor of children and the cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        // Iterate through both arrays
        while (child < g.length && cookie < s.length) {
            // If the current cookie can satisfy the current child
            if (s[cookie] >= g[child]) {
                child++; // Move to the next child
            }
            cookie++; // Move to the next cookie
        }

        return child; // Return the number of satisfied children
    }
}