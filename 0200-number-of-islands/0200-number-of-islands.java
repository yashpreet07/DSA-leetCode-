class Solution {
    int dx[] = {0,0,-1,1};
    int dy[] = {-1,1,0,0};
    int m;
    int n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i = 0 ;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(int i,int j,char[][] grid){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' || grid[i][j] == '2'){
            return;
        }
        grid[i][j] = '2';
        for(int k = 0;k < 4;k++){
            int ii = i + dx[k];
            int jj = j + dy[k];
            dfs(ii,jj,grid);
        }
    }
}