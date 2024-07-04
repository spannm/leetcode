package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0376 extends LeetcodeProblem {

    int wiggleMaxLength(int[] _nums) {
        int len = _nums.length;
        int[] up = new int[len];
        int[] down = new int[len];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < len; i++) {
            if (_nums[i] > _nums[i - 1]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (_nums[i] < _nums[i - 1]) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(down[len - 1], up[len - 1]);
    }

}
