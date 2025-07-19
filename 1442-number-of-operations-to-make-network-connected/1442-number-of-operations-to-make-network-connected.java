class Solution {
    public int makeConnected(int n, int[][] connections) {
        // Creating the graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        int conCount = 0;
        for(int con[] : connections){
            int a = con[0];
            int b = con[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
            conCount++;
        }
        // To get number of components.
        int nc = 0;
        boolean visted[] = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!visted[i]){
                dfs(i,visted,adj);
                nc++;
            }
        }

    return conCount >= n - 1 ? nc - 1 : -1;
    }
    void dfs(int node,boolean visted[],List<List<Integer>> adj){
        visted[node] = true;
        for(int ngr : adj.get(node)){
            if(!visted[ngr])
                dfs(ngr,visted,adj);
        }
    }
}