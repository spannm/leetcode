package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1434. Number of Ways to Wear Different Hats to Each Other.
 */
class Problem1434 extends LeetcodeProblem {

    int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        int m = 0;
        for (var h : hats) {
            for (int v : h) {
                m = Math.max(m, v);
            }
        }
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[m + 1];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int v : hats.get(i)) {
                g[v].add(i);
            }
        }
        final int mod = (int) 1e9 + 7;
        int[][] f = new int[m + 1][1 << n];
        f[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 1 << n; j++) {
                f[i][j] = f[i - 1][j];
                for (int k : g[i]) {
                    if ((j >> k & 1) == 1) {
                        f[i][j] = (f[i][j] + f[i - 1][j ^ 1 << k]) % mod;
                    }
                }
            }
        }
        return f[m][(1 << n) - 1];
    }

}
