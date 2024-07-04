package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/longest-cycle-in-a-graph/"> 2360. Longest Cycle in a Graph</a>.
 */
class Problem2360 extends LeetcodeProblem {

    int longestCycle(int[] _edges) {
        final int nbEdges = _edges.length;
        final int[] nodeVisitedAtTime = new int[nbEdges];

        int longestCycleLen = -1;
        int timeStep = 1;

        for (int currNode = 0; currNode < nbEdges; ++currNode) {
            if (nodeVisitedAtTime[currNode] > 0) {
                continue;
            }
            final int startTime = timeStep;
            int u = currNode;
            while (u != -1 && nodeVisitedAtTime[u] == 0) {
                nodeVisitedAtTime[u] = timeStep++;
                u = _edges[u];
            }
            if (u != -1 && nodeVisitedAtTime[u] >= startTime) {
                longestCycleLen = Math.max(longestCycleLen, timeStep - nodeVisitedAtTime[u]);
            }
        }

        return longestCycleLen;
    }

}
