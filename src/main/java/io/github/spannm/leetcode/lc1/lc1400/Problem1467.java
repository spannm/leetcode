package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1467. Probability of a Two Boxes Having The Same Number of Distinct Balls.
 */
class Problem1467 extends LeetcodeProblem {

    private int                            n;
    private long[][]                       c;
    private int[]                          balls;
    private final Map<List<Integer>, Long> f = new HashMap<>();

    double getProbability(int[] _balls) {
        int mx = 0;
        for (int x : _balls) {
            n += x;
            mx = Math.max(mx, x);
        }
        n >>= 1;
        balls = _balls;
        int m = Math.max(mx, n << 1);
        c = new long[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
            }
        }
        return dfs(0, n, 0) * 1.0 / c[n << 1][n];
    }

    long dfs(int i, int j, int diff) {
        if (i >= balls.length) {
            return j == 0 && diff == 0 ? 1 : 0;
        } else if (j < 0) {
            return 0;
        }
        List<Integer> key = List.of(i, j, diff);
        if (f.containsKey(key)) {
            return f.get(key);
        }
        long ans = 0;
        for (int x = 0; x <= balls[i]; x++) {
            int y = x == balls[i] ? 1 : x == 0 ? -1 : 0;
            ans += dfs(i + 1, j - x, diff + y) * c[balls[i]][x];
        }
        f.put(key, ans);
        return ans;
    }

}
