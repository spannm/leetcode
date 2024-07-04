package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2896. Apply Operations to Make Two Strings Equal.
 */
class Problem2896 extends LeetcodeProblem {

    private final List<Integer> idx = new ArrayList<>();
    private Integer[][]         f;
    private int                 x;

    int minOperations(String _s1, String _s2, int _x) {
        int n = _s1.length();
        for (int i = 0; i < n; i++) {
            if (_s1.charAt(i) != _s2.charAt(i)) {
                idx.add(i);
            }
        }
        int m = idx.size();
        if (m % 2 == 1) {
            return -1;
        }
        x = _x;
        f = new Integer[m][m];
        return dfs(0, m - 1);
    }

    private int dfs(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        f[i][j] = dfs(i + 1, j - 1) + x;
        f[i][j] = Math.min(f[i][j], dfs(i + 2, j) + idx.get(i + 1) - idx.get(i));
        f[i][j] = Math.min(f[i][j], dfs(i, j - 2) + idx.get(j) - idx.get(j - 1));
        return f[i][j];
    }

}
