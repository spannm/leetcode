package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 795. Number of Subarrays with Bounded Maximum.
 */
class Problem0795 extends LeetcodeProblem {

    int numSubarrayBoundedMax(int[] _nums, int _left, int _right) {
        return f(_nums, _right) - f(_nums, _left - 1);
    }

    private int f(int[] _nums, int _x) {
        int cnt = 0;
        int t = 0;
        for (int v : _nums) {
            t = v > _x ? 0 : t + 1;
            cnt += t;
        }
        return cnt;
    }

}
