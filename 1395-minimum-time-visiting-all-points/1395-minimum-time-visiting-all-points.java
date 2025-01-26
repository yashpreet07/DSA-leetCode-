class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int i = 0;
        int timeTaken = 0;
        while(i + 1 < points.length){
        int currPosX = points[i][0];
        int currPosY = points[i][1];
        int nextPosX = points[i + 1][0];
        int nextPosY = points[i + 1][1];
        int xDist = Math.abs(nextPosX - currPosX);
        int yDist = Math.abs(nextPosY - currPosY);
        timeTaken += Math.max(xDist,yDist);
        i++; 
        }
    return timeTaken;
    }
}