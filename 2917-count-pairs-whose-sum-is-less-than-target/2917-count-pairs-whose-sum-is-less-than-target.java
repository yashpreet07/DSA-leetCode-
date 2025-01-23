class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int count = 0;
        for(int i = 0;i < nums.size();i++){
            int j = i + 1;
            while(j < nums.size()){
                if((nums.get(i) + nums.get(j)) < target)
                    count++;
                j++;
            }
        }
        return count;
    }
}