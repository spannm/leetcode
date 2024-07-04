package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2293 extends LeetcodeProblem {

    int minMaxGame(int[] _nums) {
        if (_nums.length == 1) {
            return _nums[0];
        }
        int[] newNums = new int[_nums.length / 2];
        boolean min = true;
        for (int i = 0, j = 0; i < _nums.length; i += 2, j++) {
            if (min) {
                min = false;
                newNums[j] = Math.min(_nums[i], _nums[i + 1]);
            } else {
                min = true;
                newNums[j] = Math.max(_nums[i], _nums[i + 1]);
            }
        }
        return minMaxGame(newNums);
    }

}
