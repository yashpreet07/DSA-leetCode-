class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> n = new ArrayList<>();
        for(int num : nums){
            n.add(num);
        }
        backtrack(n,0,res);
        return res;
    }
    void backtrack(List<Integer> n,int start,List<List<Integer>> res){
        // Base Condition:
        if(start == n.size()){
            res.add(new ArrayList<>(n));
            return;
        }
        Set<Integer> s = new HashSet<>();
        // Choice Loop:
        for(int i = start;i < n.size();i++){
            if(s.contains(n.get(i)))
                continue;
            s.add(n.get(i));
            Collections.swap(n, start, i);

            backtrack(n,start + 1,res);

            // Backtrack:
            Collections.swap(n, start, i);
        }
    }
}