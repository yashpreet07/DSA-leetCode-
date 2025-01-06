// Your Brute Force code beats only 35% Tc:O(n^2);
// class Solution {
//     public int[] minOperations(String boxes) {
//         int n = boxes.length();
//         int ans[] = new int[n];
//         for(int i = 0;i < n;i++){
//             for(int j = 0;j < n;j++){
//              if(boxes.charAt(j) == '1'){
//                 ans[i] += Math.abs(j - i);
//                 }
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        
        // Left-to-right pass
        int leftBalls = 0, leftOps = 0;
        for (int i = 0; i < n; i++) {
            // Add operations from the left side to the current index
            ans[i] += leftOps;
            
            // Update the left side variables if the current box has a ball
            if (boxes.charAt(i) == '1') {
                leftBalls++;
            }
            // Increment leftOps to include all leftBalls moving one step further
            leftOps += leftBalls;
        }
        
        // Right-to-left pass
        int rightBalls = 0, rightOps = 0;
        for (int i = n - 1; i >= 0; i--) {
            // Add operations from the right side to the current index
            ans[i] += rightOps;
            
            // Update the right side variables if the current box has a ball
            if (boxes.charAt(i) == '1') {
                rightBalls++;
            }
            // Increment rightOps to include all rightBalls moving one step further
            rightOps += rightBalls;
        }
        
        return ans;
    }
}
