class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> fwdNgr = new ArrayList<>();
        List<List<Integer>> backNgr = new ArrayList<>();
        for(int i = 0;i < n;i++){
            fwdNgr.add(new ArrayList<>());
            backNgr.add(new ArrayList<>());
        }
        for(int []con : connections){
            int from = con[0];
            int to = con[1];
            fwdNgr.get(from).add(to);
            backNgr.get(to).add(from);
        }
        boolean visted[] = new boolean[n];
        int ans[] =  new int[1];
        dfs(0,fwdNgr,backNgr,visted,ans);
        return ans[0];
    }

    void dfs(int node,List<List<Integer>> fwdNgr,List<List<Integer>> backNgr,boolean []visted,int ans[]){
        visted[node] = true;

        // Reverse the forward neighbours
        for(int ngr : fwdNgr.get(node)){
            if(!visted[ngr]){
                ans[0]++;
                dfs(ngr,fwdNgr,backNgr,visted,ans);
            }
        }
        for(int ngr : backNgr.get(node)){
            if(!visted[ngr]){    
            dfs(ngr,fwdNgr,backNgr,visted,ans);
            }
        }
    }
}