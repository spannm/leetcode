package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 787. Cheapest Flights Within K Stops.
 */
class Problem0787 extends LeetcodeProblem {

    int findCheapestPrice(int _n, int[][] _flights, int _src, int _dst, int _k) {
        int inf = 0x3f3f3f3f;
        int[] dist = new int[_n];
        int[] backup = new int[_n];
        Arrays.fill(dist, inf);
        dist[_src] = 0;
        for (int i = 0; i < _k + 1; i++) {
            System.arraycopy(dist, 0, backup, 0, _n);
            for (int[] e : _flights) {
                int f = e[0];
                int t = e[1];
                int p = e[2];
                dist[t] = Math.min(dist[t], backup[f] + p);
            }
        }
        return dist[_dst] == inf ? -1 : dist[_dst];
    }

}
