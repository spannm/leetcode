package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 978. Longest Turbulent Subarray.
 */
class Problem0978 extends LeetcodeProblem {

    int maxTurbulenceSize(int[] _arr) {
        int ans = 1;
        int f = 1;
        int g = 1;
        for (int i = 1; i < _arr.length; i++) {
            int ff = _arr[i - 1] < _arr[i] ? g + 1 : 1;
            int gg = _arr[i - 1] > _arr[i] ? f + 1 : 1;
            f = ff;
            g = gg;
            ans = Math.max(ans, Math.max(f, g));
        }
        return ans;
    }

}
