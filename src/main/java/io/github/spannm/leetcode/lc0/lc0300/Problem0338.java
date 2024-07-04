package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/counting-bits/">338. Counting Bits</a>.
 */
class Problem0338 extends LeetcodeProblem {

    int[] countBits(int _n) {
        final int[] ans = new int[_n + 1];
        for (int i = 1; i <= _n; i++) {
            ans[i] = ans[i & i - 1] + 1;
        }
        return ans;
    }

}
