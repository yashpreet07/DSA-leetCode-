class Solution {
    // This Approach has TC--->O(n) and SC---->O(1)
    public int singleNumber(int[] nums) {
        int sNum = 0;
        for (int x : nums)
            sNum ^= x;
        return sNum;
    }
}
// This Approach has TC--->O(n) but SC---->O(n)
// Map<Integer,Integer> map=new HashMap<>();
// int count=1;
// for (int ele : nums) {
// map.put(ele, map.getOrDefault(ele, 0) + 1);
// }
// for (int ele : nums) {
// if (map.get(ele) == 1) {
// return ele;
// }
// }
// return -1;