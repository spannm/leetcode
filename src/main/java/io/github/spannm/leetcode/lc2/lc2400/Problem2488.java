package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2488. Count Subarrays With Median K.
 */
class Problem2488 extends LeetcodeProblem {

    int countSubarrays(int[] _nums, int _k) {
        int len = _nums.length;
        int i = 0;
        while (_nums[i] != _k) {
            i++;
        }
        int[] cnt = new int[len << 1 | 1];
        int ans = 1;
        int x = 0;
        for (int j = i + 1; j < len; j++) {
            x += _nums[j] > _k ? 1 : -1;
            if (x >= 0 && x <= 1) {
                ans++;
            }
            cnt[x + len]++;
        }
        x = 0;
        for (int j = i - 1; j >= 0; j--) {
            x += _nums[j] > _k ? 1 : -1;
            if (x >= 0 && x <= 1) {
                ans++;
            }
            ans += cnt[-x + len] + cnt[-x + 1 + len];
        }
        return ans;
    }

}
