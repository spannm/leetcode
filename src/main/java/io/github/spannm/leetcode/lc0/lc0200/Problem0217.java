package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/">217. Contains Duplicate</a>.
 */
class Problem0217 extends LeetcodeProblem {

    boolean containsDuplicate(final int[] _nums) {
        final int len = _nums.length;
        if (len == 1) {
            return false;
        } else if (len == 2) {
            return _nums[0] == _nums[1];
        }

        Arrays.sort(_nums);

        for (int i = 1; i < len; i++) {
            if (_nums[i] == _nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

}
