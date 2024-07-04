package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1470 extends LeetcodeProblem {

    int[] shuffle(int[] _nums, int _n) {
        int[] result = new int[_nums.length];
        for (int i = 0, j = 0; i < _n && j < 2 * _n; i++, j++) {
            result[j] = _nums[i];
            result[++j] = _nums[i + _n];
        }
        return result;
    }

}
