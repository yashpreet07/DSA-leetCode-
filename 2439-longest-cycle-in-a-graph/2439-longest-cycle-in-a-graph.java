class Solution {
    int longestCycleLen = -1;

    void dfsFindLongestCycle(int cycleLen, int node, int[] currentPath, int[] visitedNodeList, int[] edges) {
        cycleLen++;
        currentPath[node] = cycleLen;
        visitedNodeList[node] = 1;

        int nbr = edges[node];
        if (nbr != -1) {
            if (visitedNodeList[nbr] == 0) {
                dfsFindLongestCycle(cycleLen, nbr, currentPath, visitedNodeList, edges);
            } else if (currentPath[nbr] != 0) {
                int currCycleLen = currentPath[node] - currentPath[nbr] + 1;
                longestCycleLen = Math.max(longestCycleLen, currCycleLen);
            }
        }

        currentPath[node] = 0; // Backtrack
    }

    public int longestCycle(int[] edges) {
        int numOfNodes = edges.length;
        int[] visitedNodeList = new int[numOfNodes];
        int[] currentPath = new int[numOfNodes];

        for (int i = 0; i < numOfNodes; i++) {
            if (visitedNodeList[i] == 0) {
                dfsFindLongestCycle(0, i, currentPath, visitedNodeList, edges);
            }
        }

        return longestCycleLen;
    }
}