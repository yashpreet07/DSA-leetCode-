// Your Code beats 26%  
// class Solution {
//     public int maxCount(int[] banned, int n, int maxSum) {
//         int c = 0;
//         int sum = 0;
//         Set<Integer> s = new HashSet<>();
//         for(int  i : banned)
//             s.add(i);
//         for(int  i = 1;i <= n;i++)
//         {
//             if(!(s.contains(i)))
//             {
//                 sum += i;
//                 if(sum <= maxSum)
//                     c++;
//             }
//         }
//     return c;
//     }
// }
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Use a HashSet for O(1) lookups of banned numbers
        Set<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int count = 0, sum = 0;

        // Iterate through numbers starting from 1
        for (int i = 1; i <= n; i++) {
            if (!bannedSet.contains(i)) { // Skip banned numbers
                if (sum + i > maxSum) {
                    break; // Early exit if adding i exceeds maxSum
                }
                sum += i; // Add the number to the sum
                count++; // Increment count
            }
        }

        return count;
    }
}