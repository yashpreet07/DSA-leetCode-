class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int []edge : edges){
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a,k->new ArrayList<>()).add(b);
            graph.computeIfAbsent(b,k->new ArrayList<>()).add(a);
        }
        // DFS trav.
        boolean visted[] = new boolean[n + 1];
        dfs(source,graph,visted);
        return visted[destination];
    }
    void dfs(int src,Map<Integer,List<Integer>> graph,boolean[] visted){
        visted[src] = true;
        for(int ngr : graph.getOrDefault(src,new ArrayList<>())){
            if(!visted[ngr]){
                dfs(ngr,graph,visted);
            }
        }
    }
}