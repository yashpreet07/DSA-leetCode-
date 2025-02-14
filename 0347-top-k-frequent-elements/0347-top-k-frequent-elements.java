class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int ele : nums){
            mp.put(ele,mp.getOrDefault(ele,0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            minHeap.add(new int[]{entry.getValue(), entry.getKey()});
            if (minHeap.size() > k)
                minHeap.poll();
}
        // for(int i = 0;i < nums.length;i++){
        //     minHeap.add(new int[]{mp.get(nums[i]),nums[i]});
        //     if(minHeap.size() > k)
        //         minHeap.poll();
        // }
        int j = 0;
        int res[] = new int[k];
        while(!minHeap.isEmpty()){
            res[j] = minHeap.poll()[1];
            j++;
        }
        return res;
    }
}