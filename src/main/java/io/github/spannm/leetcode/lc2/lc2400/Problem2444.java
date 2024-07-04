package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/count-subarrays-with-fixed-bounds/">2444. Count Subarrays With Fixed
 * Bounds</a>.
 */
class Problem2444 extends LeetcodeProblem {

    long countSubarrays(int[] _nums, int _minK, int _maxK) {
        final int len = _nums.length;
        if (len <= 1) {
            if (len == 0) {
                return 0;
            } else if (_minK == _maxK && _minK == _nums[0]) {
                return 1;
            }
        }

        long count = 0;
        int bad = -1;
        int min = -1;
        int max = -1;
        for (int i = 0; i < len; i++) {
            if (_nums[i] < _minK || _nums[i] > _maxK) {
                bad = i;
            }
            if (_nums[i] == _minK) {
                min = i;
            }
            if (_nums[i] == _maxK) {
                max = i;
            }
            count += Math.max(0L, Math.min(min, max) - bad);
        }
        return count;
    }

}
