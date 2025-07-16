class Solution {
    public int[] findOrder(int n, int[][] prereq) {
        int [] order = new int[n];
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

        if(lst.size() != n)
            return new int[]{};
        else{
            for(int i = 0;i < n;i++){
                order[i] = lst.get(i);
            }
            return order;
        }
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


    //     int [] order = new int[n];
    //     List<List<Integer>> adj = new ArrayList<>();
    //     for(int i = 0;i < n;i++){
    //         adj.add(new ArrayList<>());
    //     }
    //     for(int ele[] : prereq){
    //         int a = ele[0];
    //         int b = ele[1];
    //         adj.get(b).add(a);
    //     }
    //     // To Check for Directed Edeges
    //     boolean visted[] = new boolean[n];
    //     Deque<Integer> dq = new LinkedList<>();
    //     for(int i = 0;i < n;i++){
    //         if(!visted[i])
    //             dfs(i,dq,visted,adj);
    //     }
    //     int i = 0;
    //     while(!dq.isEmpty()){
    //         order[i] = dq.pollFirst();
    //         i++;
    //     }
    //     return order;
    // }

    // void dfs(int node,Deque<Integer> dq,boolean [] visted,List<List<Integer>> adj){
    //     visted[node] = true;
    //     for(int ngr : adj.get(node)){
    //         if(!visted[ngr])
    //             dfs(ngr,dq,visted,adj);
    //     }
    //     dq.offerFirst(node);
    // }