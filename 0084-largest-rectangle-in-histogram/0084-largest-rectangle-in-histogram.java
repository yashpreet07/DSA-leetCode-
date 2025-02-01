class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int R[] = new int [n];
        int L[] = new int [n];
        int A[] = new int[n];
        // NSL
        Stack<int[]> s1 = new Stack<>();
        int pI = -1;
        for(int i = 0;i < n;i++){
            while(!s1.isEmpty() && s1.peek()[0] >= heights[i]){
                s1.pop();
            }
            L[i] = (s1.isEmpty() ? pI : s1.peek()[1]);
            s1.push(new int[]{heights[i],i});
        }
        // NSR
        Stack<int[]> s2 = new Stack<>();
        pI = n;
        for(int i = n - 1;i >= 0;i--){
            while(!s2.isEmpty() && s2.peek()[0] >= heights[i]){
                s2.pop();
            }
            R[i] = (s2.isEmpty() ? pI : s2.peek()[1]);
            s2.push(new int[]{heights[i],i});
        }
        // Area
        int maxArea = 0;
        for(int i = 0;i < n;i++){
            A[i] = (R[i] - L[i] - 1) * heights[i];
            maxArea = Math.max(maxArea,A[i]);
        }
        return maxArea;
    }
}