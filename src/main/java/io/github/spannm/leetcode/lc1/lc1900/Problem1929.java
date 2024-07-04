package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1929 extends LeetcodeProblem {

    int[] getConcatenation(int[] _nums) {
        int[] result = new int[_nums.length * 2];
        int i = 0;
        for (; i < _nums.length; i++) {
            result[i] = _nums[i];
        }
        for (int j = 0; i < result.length && j < _nums.length; i++, j++) {
            result[i] = _nums[j];
        }
        return result;
    }

}
