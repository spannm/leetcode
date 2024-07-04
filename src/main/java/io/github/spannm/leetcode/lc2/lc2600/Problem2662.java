package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2662. Minimum Cost of a Path With Special Roads.
 */
class Problem2662 extends LeetcodeProblem {

    int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int ans = 1 << 30;
        int n = 1000000;
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<Long> vis = new HashSet<>();
        q.offer(new int[] {0, start[0], start[1]});
        while (!q.isEmpty()) {
            var p = q.poll();
            int x = p[1];
            int y = p[2];
            long k = 1L * x * n + y;
            if (vis.contains(k)) {
                continue;
            }
            vis.add(k);
            int d = p[0];
            ans = Math.min(ans, d + dist(x, y, target[0], target[1]));
            for (var r : specialRoads) {
                int x1 = r[0];
                int y1 = r[1];
                int x2 = r[2];
                int y2 = r[3];
                int cost = r[4];
                q.offer(new int[] {d + dist(x, y, x1, y1) + cost, x2, y2});
            }
        }
        return ans;
    }

    private int dist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}
