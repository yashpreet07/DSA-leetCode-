class Solution {
    public int findLucky(int[] arr) {
        int lN = -1;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int ele : arr){
            mp.put(ele,mp.getOrDefault(ele,0) + 1);
        }
        Arrays.sort(arr);
        for(int ele : arr){
            if(mp.get(ele) == ele)
                lN = ele;
        }
        return lN;
    }
}