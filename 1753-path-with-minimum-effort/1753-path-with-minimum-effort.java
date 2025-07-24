class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int minimumEffortPath(int[][] h) {
        int r = h.length;
        int c = h[0].length;

        int[][] dis = new int[r][c];
        for (int[] row : dis) Arrays.fill(row, Integer.MAX_VALUE);
        dis[0][0] = 0;

        // {effort, x, y}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // effort, row, col

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int effort = curr[0];
            int x = curr[1];
            int y = curr[2];

            // Reached target
            if (x == r - 1 && y == c - 1) {
                return effort;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                    int newEffort = Math.max(effort, Math.abs(h[x][y] - h[nx][ny]));
                    if (newEffort < dis[nx][ny]) {
                        dis[nx][ny] = newEffort;
                        pq.offer(new int[]{newEffort, nx, ny});
                    }
                }
            }
        }

        return 0; // Should never be reached
    }
}

// class Solution {
//     int dx[] = {1,0,0,-1};
//     int dy[] = {0,1,-1,0};
//     public int minimumEffortPath(int[][] h {
//         // Just have to apply Dijkstra on grid.
//         int r = h.length;
//         int c = h[0].length;
//         int dis[][] = new int[r][c];
//         Arrays.fill(dis,Integer.MAX_VALUE);
//         dis[0][0] = 0;
//         PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
//         pq.offer(new int[]{0,h[0][0]});
//         while(!pq.isEmpty()){
//             int []curr = pq.poll();

//         }
//     }
// }