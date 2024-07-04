package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 992. Subarrays with K Different Integers.
 */
class Problem0992 extends LeetcodeProblem {

    int subarraysWithKDistinct(int[] _nums, int _k) {
        int[] left = f(_nums, _k);
        int[] right = f(_nums, _k - 1);
        int ans = 0;
        for (int i = 0; i < _nums.length; i++) {
            ans += right[i] - left[i];
        }
        return ans;
    }

    static int[] f(int[] _nums, int _k) {
        int n = _nums.length;
        int[] cnt = new int[n + 1];
        int[] pos = new int[n];
        int s = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (++cnt[_nums[i]] == 1) {
                s++;
            }
            for (; s > _k; j++) {
                if (--cnt[_nums[j]] == 0) {
                    s--;
                }
            }
            pos[i] = j;
        }
        return pos;
    }

}
