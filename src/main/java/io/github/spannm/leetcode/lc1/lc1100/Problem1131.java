package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1131. Maximum of Absolute Value Expression.
 */
class Problem1131 extends LeetcodeProblem {

    int maxAbsValExpr(int[] _arr1, int[] _arr2) {
        int[] dirs = {1, -1, -1, 1, 1};
        final int inf = 1 << 30;
        int ans = -inf;
        int n = _arr1.length;
        for (int k = 0; k < 4; k++) {
            int a = dirs[k];
            int b = dirs[k + 1];
            int mx = -inf;
            int mi = inf;
            for (int i = 0; i < n; i++) {
                mx = Math.max(mx, a * _arr1[i] + b * _arr2[i] + i);
                mi = Math.min(mi, a * _arr1[i] + b * _arr2[i] + i);
                ans = Math.max(ans, mx - mi);
            }
        }
        return ans;
    }

}
