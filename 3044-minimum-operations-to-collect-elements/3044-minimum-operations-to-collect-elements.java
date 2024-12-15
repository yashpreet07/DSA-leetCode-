// Your Code beats 38%
// class Solution {
//     public int minOperations(List<Integer> nums, int k) {
//         int temp = k;
//         Set<Integer> s = new HashSet<>();
//         while(temp > 0)
//         {
//             s.add(temp);
//             temp--;
//         }
//         int count = 0;
//         int i = nums.size() - 1;
//         while(i > 0)
//         {
//             if(s.contains(nums.get(i)))
//             {
//                 count++;
//                 s.remove(nums.get(i));
//             }
                
//             if(count == k)
//             break;
//             i--;
//         }
//         return (nums.size() - i);
//     }
// }
class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int total_op = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            total_op++;
            if (nums.get(i) <= k) {
                set.add(nums.get(i));
            } 
            if(set.size()==k)break;
        }

        return total_op;
    }
}