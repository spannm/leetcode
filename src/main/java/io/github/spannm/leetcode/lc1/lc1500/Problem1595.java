package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;

/**
 * 1595. Minimum Cost to Connect Two Groups of Points.
 */
class Problem1595 extends LeetcodeProblem {

    int connectTwoGroups(List<List<Integer>> cost) {
        int m = cost.size();
        int n = cost.get(0).size();
        final int inf = 1 << 30;
        int[] f = new int[1 << n];
        Arrays.fill(f, inf);
        f[0] = 0;
        int[] g = f.clone();
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 1 << n; j++) {
                g[j] = inf;
                for (int k = 0; k < n; k++) {
                    if ((j >> k & 1) == 1) {
                        int c = cost.get(i - 1).get(k);
                        g[j] = Math.min(g[j], g[j ^ 1 << k] + c);
                        g[j] = Math.min(g[j], f[j] + c);
                        g[j] = Math.min(g[j], f[j ^ 1 << k] + c);
                    }
                }
            }
            System.arraycopy(g, 0, f, 0, 1 << n);
        }
        return f[(1 << n) - 1];
    }

}
