package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/min-cost-to-connect-all-points/">1584. Min Cost to Connect All Points</a>.
 */
class Problem1584 extends LeetcodeProblem {

    int minCostConnectPoints(int[][] _points) {
        final int nbPoints = _points.length;
        int[] dist = new int[nbPoints];
        int minDist;
        int res = 0;

        Arrays.fill(dist, Integer.MAX_VALUE - 1);

        int cntr = nbPoints;
        int curr = 0;
        int nextPnt = 0;
        while (cntr-- > 1) { // since there are n-1 edges in MST
            minDist = dist[curr] = Integer.MAX_VALUE;
            for (int i = 0; i < nbPoints; i++) { // for each curr node, updating all other min distances
                if (dist[i] != Integer.MAX_VALUE) { // marking visited nodes
                    dist[i] = Math.min(dist[i],
                        Math.abs(_points[i][0] - _points[curr][0])
                            + Math.abs(_points[i][1] - _points[curr][1]));
                    if (dist[i] < minDist) { // finding the next minimum distance point as in pseudo heap
                        nextPnt = i;
                        minDist = dist[i];
                    }
                }
            }
            curr = nextPnt;
            res += dist[curr];
        }

        _points = null;
        dist = null;

        return res;
    }

}
