class Solution {
    int dx[] = {-1,0,1,0};
    int dy[] = {0,-1,0,1};
    int row;
    int col;
    void bfs(int i,int j,int [][]image,int color,int org_color){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});   
        while(!q.isEmpty()){
            int cell[] =  q.poll();
            int ii = cell[0];
            int jj = cell[1];

            for(int k = 0;k < 4;k++){
                int ni = ii + dx[k];
                int nj = jj + dy[k];
                if (ni >= 0 && ni < row && nj >= 0 && nj < col && image[ni][nj] == org_color){
                    image[ni][nj] = color;
                    q.offer(new int[]{ni,nj});
                }
            }
        }   
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org_color = image[sr][sc];
        row = image.length;
        col = image[0].length;
        if(org_color == color)
            return image;
        image[sr][sc] = color;
        bfs(sr,sc,image,color,org_color);
        return image;
    }
}