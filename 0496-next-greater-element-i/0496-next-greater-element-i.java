class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.empty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int j = 0;
        for(int i : nums1) {
            nums1[j++] = (map.containsKey(i)? map.get(i) : -1 );
        }
        return nums1;
    }
}
// My code!!
// class Solution {
//     Stack<Integer> s = new Stack<>();
//     Map<Integer,Integer> mp = new HashMap<>();
//     public int[] nextGreaterElement(int[] nums1, int[] arr) {
//         for(int i = arr.length - 1;i >= 0;i--){
//             if(s.size() == 0){
//                 mp.put(arr[i] , -1);
//             }
//             else if(s.size() > 0 && s.peek() > arr[i]){
//                 mp.put(arr[i],s.peek());
//             }
//             else if(s.size() > 0 && s.peek() < arr[i]){
//                 while(s.size() > 0 && s.peek() <= arr[i])
//                     s.pop();
//                 if(s.size() == 0)
//                     mp.put(arr[i],-1);
//                 else
//                     mp.put(arr[i],s.peek());
//             }
//             s.push(arr[i]);
//         }
//         int ans[] = new int[nums1.length];
//         for(int i = 0;i < nums1.length;i++){
//             ans[i] = mp.get(nums1[i]);
//         }
//         return ans;
//     }
// }