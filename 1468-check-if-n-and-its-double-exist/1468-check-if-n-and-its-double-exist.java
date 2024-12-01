// Your Code with o(n^2)
// class Solution {
//     public boolean checkIfExist(int[] arr) {
//         for(int i = 0;i < arr.length;i++)
//         {
//             for(int  j = 0;j < arr.length;j++)
//             {
//                 if(i != j && ((arr[i]) == 2 * (arr[j])))
//                     return true;
//             }
//         }
//     return false;
//     }
// }
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i * 2)) return true;
            if (i % 2 == 0 && set.contains(i / 2)) return true;
            set.add(i);
        }
        return false;
    }
}