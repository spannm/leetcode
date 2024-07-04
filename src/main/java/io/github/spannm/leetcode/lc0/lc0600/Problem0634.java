package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0634 extends LeetcodeProblem {
    private static final int M = 1000000007;

    int findDerangement(int _n) {
        long ans = 1;
        for (int i = 1; i <= _n; i++) {
            ans = (i * ans % M + (i % 2 == 0 ? 1 : -1)) % M;
        }
        return (int) ans;
    }

}
