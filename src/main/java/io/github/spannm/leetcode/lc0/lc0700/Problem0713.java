package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0713 extends LeetcodeProblem {

    int numSubarrayProductLessThanK(int[] _nums, int _k) {
        if (_k < 2) {
            return 0;
        }
        int len = _nums.length;
        int result = 0;
        for (int i = 0, right = 0, product = 1; right < len; right++) {
            product *= _nums[right];
            while (i < len && product >= _k) {
                product /= _nums[i++];
            }
            result += right - i + 1;
        }
        return result;
    }

}
