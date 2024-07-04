package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 995. Minimum Number of K Consecutive Bit Flips.
 */
class Problem0995 extends LeetcodeProblem {

    int minKBitFlips(int[] _nums, int _k) {
        int len = _nums.length;
        int[] d = new int[len + 1];
        int ans = 0;
        int s = 0;
        for (int i = 0; i < len; i++) {
            s += d[i];
            if (_nums[i] % 2 == s % 2) {
                if (i + _k > len) {
                    return -1;
                }
                d[i]++;
                d[i + _k]--;
                s++;
                ans++;
            }
        }
        return ans;
    }

}
