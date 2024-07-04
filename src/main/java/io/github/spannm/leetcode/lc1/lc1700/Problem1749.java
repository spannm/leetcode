package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1749 extends LeetcodeProblem {

    int maxAbsoluteSum(int[] _nums) {
        int min = 0;
        int max = 0;
        int s = 0;
        for (int num : _nums) {
            s += num;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        return max - min;
    }

}
