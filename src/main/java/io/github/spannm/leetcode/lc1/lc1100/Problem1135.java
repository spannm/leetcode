package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1135. Connecting Cities With Minimum Cost.
 */
class Problem1135 extends LeetcodeProblem {

    private int[] p;

    int minimumCost(int _n, int[][] _connections) {
        Arrays.sort(_connections, Comparator.comparingInt(a -> a[2]));
        p = new int[_n];
        for (int i = 0; i < _n; i++) {
            p[i] = i;
        }
        int ans = 0;
        for (int[] e : _connections) {
            int x = e[0] - 1;
            int y = e[1] - 1;
            int cost = e[2];
            if (find(x) == find(y)) {
                continue;
            }
            p[find(x)] = find(y);
            ans += cost;
            if (--_n == 1) {
                return ans;
            }
        }
        return -1;
    }

    int find(int _x) {
        if (p[_x] != _x) {
            p[_x] = find(p[_x]);
        }
        return p[_x];
    }

}
