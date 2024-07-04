package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1031. Maximum Sum of Two Non-Overlapping Subarrays.
 */
class Problem1031 extends LeetcodeProblem {

    int maxSumTwoNoOverlap(int[] _nums, int _firstLen, int _secondLen) {
        int n = _nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + _nums[i];
        }
        int ans = 0;
        for (int i = _firstLen, t = 0; i + _secondLen - 1 < n; i++) {
            t = Math.max(t, s[i] - s[i - _firstLen]);
            ans = Math.max(ans, t + s[i + _secondLen] - s[i]);
        }
        for (int i = _secondLen, t = 0; i + _firstLen - 1 < n; i++) {
            t = Math.max(t, s[i] - s[i - _secondLen]);
            ans = Math.max(ans, t + s[i + _firstLen] - s[i]);
        }
        return ans;
    }

}
