class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int count = 0;
        for(int no : nums)
        {
            if(no == 1)
              count++;
            else
            {
                maxOnes = Math.max(maxOnes,count);
                count = 0;
            }
        }
        maxOnes = Math.max(maxOnes,count);
    return maxOnes;
    }
}