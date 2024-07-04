package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 932. Beautiful Array.
 */
class Problem0932 extends LeetcodeProblem {

    int[] beautifulArray(int _n) {
        if (_n == 1) {
            return new int[] {1};
        }
        int[] left = beautifulArray(_n + 1 >> 1);
        int[] right = beautifulArray(_n >> 1);
        int[] ans = new int[_n];
        int i = 0;
        for (int x : left) {
            ans[i++] = x * 2 - 1;
        }
        for (int x : right) {
            ans[i++] = x * 2;
        }
        return ans;
    }

}
