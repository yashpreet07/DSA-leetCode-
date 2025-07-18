class Solution {
    int dx[] = {0,1,-1,0};
    int dy[] = {1,0,0,-1};
    int m , n;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Queue<int []> q = new LinkedList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 2){
                 q.offer(new int[]{i,j});   
                }
            }
        }
        int level = bfs(q,grid);

        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return level;
    }

    int bfs(Queue<int []> q,int [][]grid){
        int time = -1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int cell[] = q.poll();
                for(int k = 0; k < 4;k++){
                    int ii = cell[0] + dx[k];
                    int jj = cell[1] + dy[k];
                    if( ii >= 0 && ii < m && jj >= 0 && jj < n && grid[ii][jj] == 1){
                        grid[ii][jj] = 2;
                        q.offer(new int[]{ii,jj});
                    }
                }
            }
            time += 1;
        }
        return time == -1 ? 0 : time;
    }
}