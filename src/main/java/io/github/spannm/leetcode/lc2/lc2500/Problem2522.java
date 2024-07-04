package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2522. Partition String Into Substrings With Values at Most K.
 */
class Problem2522 extends LeetcodeProblem {

    private static final int INF = 1 << 30;

    private String           s;
    private int              k;
    private int              n;
    private Integer[]        f;

    int minimumPartition(String _s, int _k) {
        s = _s;
        k = _k;
        n = _s.length();
        f = new Integer[n];
        int ans = dfs(0);
        return ans < INF ? ans : -1;
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        } else if (f[i] != null) {
            return f[i];
        }
        int res = INF;
        long v = 0;
        for (int j = i; j < n; j++) {
            v = v * 10 + (s.charAt(j) - '0');
            if (v > k) {
                break;
            }
            res = Math.min(res, dfs(j + 1));
        }
        return f[i] = res + 1;
    }

}
