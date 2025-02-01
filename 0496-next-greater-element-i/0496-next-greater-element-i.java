class Solution {
    Stack<Integer> s = new Stack<>();
    Map<Integer,Integer> mp = new HashMap<>();
    public int[] nextGreaterElement(int[] nums1, int[] arr) {
        for(int i = arr.length - 1;i >= 0;i--){
            if(s.size() == 0){
                mp.put(arr[i] , -1);
            }
            else if(s.size() > 0 && s.peek() > arr[i]){
                mp.put(arr[i],s.peek());
            }
            else if(s.size() > 0 && s.peek() < arr[i]){
                while(s.size() > 0 && s.peek() <= arr[i])
                    s.pop();
                if(s.size() == 0)
                    mp.put(arr[i],-1);
                else
                    mp.put(arr[i],s.peek());
            }
            s.push(arr[i]);
        }
        int ans[] = new int[nums1.length];
        for(int i = 0;i < nums1.length;i++){
            ans[i] = mp.get(nums1[i]);
        }
        return ans;
    }
}