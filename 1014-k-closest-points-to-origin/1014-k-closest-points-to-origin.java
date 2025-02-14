class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxH = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < points.length; i++) {
            maxH.add(new int[] { (points[i][0] * points[i][0] + points[i][1] * points[i][1]), points[i][0],
                    points[i][1] });
            if (maxH.size() > k)
                maxH.poll();
        }
        int res[][] = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] top = maxH.poll(); // Extract once
            res[i][0] = top[1];
            res[i][1] = top[2];
        }
        return res;
    }
}