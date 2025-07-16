class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        int in[] = new int[n];
        for(int ele[] : prereq){
            int a = ele[0];
            int b = ele[1];
            adj.get(b).add(a);
            in[a] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> lst = new ArrayList<>();

        for(int i = 0;i < n;i++){
            if(in[i] == 0)
                q.offer(i);
        }

        bfs(q,lst,in,adj);

        return lst.size() == n;
    }

    void bfs(Queue<Integer> q,List<Integer>lst,int [] in,List<List<Integer>> adj){  
        while(!q.isEmpty()){
            int node = q.poll();
            lst.add(node);
            for(int nbr : adj.get(node)){
                in[nbr] -= 1;
                if(in[nbr] == 0)
                    q.offer(nbr);
            }
        }
    }
}