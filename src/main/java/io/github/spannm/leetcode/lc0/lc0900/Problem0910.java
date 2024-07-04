package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 910. Smallest Range II.
 */
class Problem0910 extends LeetcodeProblem {

    int smallestRangeII(int[] _nums, int _k) {
        Arrays.sort(_nums);
        int len = _nums.length;
        int ans = _nums[len - 1] - _nums[0];
        for (int i = 1; i < len; i++) {
            int mi = Math.min(_nums[0] + _k, _nums[i] - _k);
            int mx = Math.max(_nums[i - 1] + _k, _nums[len - 1] - _k);
            ans = Math.min(ans, mx - mi);
        }
        return ans;
    }

}
