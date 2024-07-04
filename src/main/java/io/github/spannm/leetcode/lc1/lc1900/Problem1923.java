package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1923. Longest Common Subpath.
 */
class Problem1923 extends LeetcodeProblem {

    private static final int         N     = 100010;
    private final long[]             h     = new long[N];
    private final long[]             p     = new long[N];
    private int[][]                  paths;
    private final Map<Long, Integer> cnt   = new HashMap<>();
    private final Map<Long, Integer> inner = new HashMap<>();

    int longestCommonSubpath(int _n, int[][] _paths) {
        int left = 0;
        int right = _n;
        for (int[] path : _paths) {
            right = Math.min(right, path.length);
        }
        paths = _paths;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (check(mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int _mid) {
        cnt.clear();
        inner.clear();
        p[0] = 1;
        for (int j = 0; j < paths.length; j++) {
            int n = paths[j].length;
            for (int i = 1; i <= n; i++) {
                p[i] = p[i - 1] * 133331;
                h[i] = h[i - 1] * 133331 + paths[j][i - 1];
            }
            for (int i = _mid; i <= n; i++) {
                long val = get(i - _mid + 1, i);
                if (!inner.containsKey(val) || inner.get(val) != j) {
                    inner.put(val, j);
                    cnt.put(val, cnt.getOrDefault(val, 0) + 1);
                }
            }
        }
        int max = 0;
        for (int val : cnt.values()) {
            max = Math.max(max, val);
        }
        return max == paths.length;
    }

    private long get(int _l, int _r) {
        return h[_r] - h[_l - 1] * p[_r - _l + 1];
    }

}
