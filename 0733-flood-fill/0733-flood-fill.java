class Solution {
    int dx[] = {-1,0,1,0};
    int dy[] = {0,-1,0,1};
    void dfs(int i,int j,int [][]image,int color,int org_color){
        for(int k = 0;k < 4;k++){
            int ii = i + dx[k];
            int jj = j + dy[k];
            if(ii >= 0 && ii < image.length && jj >= 0 && jj < image[0].length){
                if(image[ii][jj] == org_color){
                    image[ii][jj] = color;
                    dfs(ii,jj,image,color,org_color);
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org_color = image[sr][sc];
        if(org_color == color)
            return image;
        image[sr][sc] = color;
        dfs(sr,sc,image,color,org_color);
        return image;
    }
}