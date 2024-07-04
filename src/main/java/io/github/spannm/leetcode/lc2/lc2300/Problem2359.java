package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2359. Find Closest Node to Given Two Nodes.
 */
class Problem2359 extends LeetcodeProblem {

    private int                 n;
    private List<List<Integer>> lol;

    int closestMeetingNode(int[] _edges, int _node1, int _node2) {
        n = _edges.length;
        lol = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            lol.add(l);
            if (_edges[i] != -1) {
                l.add(_edges[i]);
            }
        }
        int[] d1 = dijkstra(_node1);
        int[] d2 = dijkstra(_node2);
        int d = 1 << 30;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int t = Math.max(d1[i], d2[i]);
            if (t < d) {
                d = t;
                ans = i;
            }
        }
        return ans;
    }

    private int[] dijkstra(int i) {
        int[] dist = new int[n];
        Arrays.fill(dist, 1 << 30);
        dist[i] = 0;
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[] {0, i});
        while (!q.isEmpty()) {
            var p = q.poll();
            i = p[1];
            for (int j : lol.get(i)) {
                if (dist[j] > dist[i] + 1) {
                    dist[j] = dist[i] + 1;
                    q.offer(new int[] {dist[j], j});
                }
            }
        }
        return dist;
    }

}
