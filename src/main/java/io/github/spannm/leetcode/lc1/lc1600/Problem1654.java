package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 1654. Minimum Jumps to Reach Home.
 */
class Problem1654 extends LeetcodeProblem {

    int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> s = new HashSet<>();
        for (int v : forbidden) {
            s.add(v);
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 1});
        final int n = 6000;
        boolean[][] vis = new boolean[n][2];
        vis[0][1] = true;
        for (int ans = 0; !q.isEmpty(); ++ans) {
            for (int t = q.size(); t > 0; t--) {
                var p = q.poll();
                int i = p[0];
                int k = p[1];
                if (i == x) {
                    return ans;
                }
                List<int[]> nxt = new ArrayList<>();
                nxt.add(new int[] {i + a, 1});
                if ((k & 1) == 1) {
                    nxt.add(new int[] {i - b, 0});
                }
                for (var e : nxt) {
                    int j = e[0];
                    k = e[1];
                    if (j >= 0 && j < n && !s.contains(j) && !vis[j][k]) {
                        q.offer(new int[] {j, k});
                        vis[j][k] = true;
                    }
                }
            }
        }
        return -1;
    }

}
