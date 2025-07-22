class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        // Step 1: Flatten the board into a 1D connection array
        int[] connection = new int[n * n + 1];
        Arrays.fill(connection, -1);
        boolean leftToRight = true;
        int node = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] != -1) {
                        connection[node] = board[i][j];
                    }
                    node++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    if (board[i][j] != -1) {
                        connection[node] = board[i][j];
                    }
                    node++;
                }
            }
            leftToRight = !leftToRight;
        }

        // Step 2: Build the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n * n; i++) {
            graph.put(i, new ArrayList<>());
            for (int dice = 1; dice <= 6; dice++) {
                int nbr = i + dice;
                if (nbr <= n * n) {
                    if (connection[nbr] != -1) {
                        graph.get(i).add(connection[nbr]); // has snake or ladder
                    } else {
                        graph.get(i).add(nbr);
                    }
                }
            }
        }

        // Step 3: BFS to find the shortest path
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];
        q.offer(1);
        visited[1] = true;
        int level = 0;

        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int pos = q.poll();
                if (pos == n * n) return level;
                for (int nbr : graph.get(pos)) {
                    if (!visited[nbr]) {
                        visited[nbr] = true;
                        q.offer(nbr);
                    }
                }
            }
            level++;
        }

        return -1;
    }
}