class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list: from -> list of [to, price]
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        // PriorityQueue -> [price_so_far, city, stops_so_far]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0});

        // Store visited as city -> min stops seen so far
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[src] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int city = curr[1];
            int stops = curr[2];

            if (city == dst) return cost;

            if (stops > k || visited[city] < stops) continue;
            
            visited[city] = stops;

            if (!graph.containsKey(city)) continue;

            for (int[] nei : graph.get(city)) {
                int nextCity = nei[0];
                int priceToNext = nei[1];
                pq.offer(new int[]{cost + priceToNext, nextCity, stops + 1});
            }
        }

        return -1;
    }
}