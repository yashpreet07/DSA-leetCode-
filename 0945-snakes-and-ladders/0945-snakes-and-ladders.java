class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int count = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        boolean flow = true;
        for(int i = n - 1;i >= 0;i--){
            if(flow){
                for(int j = 0;j < n;j++){
                    count++;
                    if(board[i][j] != -1){
                        mp.put(count,board[i][j]);
                    }
                }
            }else{
                for(int j = n-1;j >= 0;j--){
                    count++;
                    if(board[i][j] != -1){
                        mp.put(count,board[i][j]);
                    }
                }
            }
            flow = !(flow);
        }

        // Creating the graph
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>()); // for the 0th index
        for(int i = 1;i <= n * n;i++){
            adj.add(new ArrayList<>());
            for(int k = 1;k <= 6;k++){
                if(i + k <= n * n){
                    if(!mp.containsKey(i + k) )
                        adj.get(i).add(i + k);
                    else
                        adj.get(i).add(mp.get(i + k));
                }
            }
        }

        return bfs(board,n,adj);
    }

    int bfs(int [][] b,int n,List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        boolean []visted = new boolean[n * n + 1];
        q.offer(1); // Src Node = 1 and destination_Node = n * n
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int node = q.poll();
                if(node == n * n)   return step;
                for(int nbr : adj.get(node)){
                    if(!visted[nbr]){
                        visted[nbr] = true;
                        q.offer(nbr);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}