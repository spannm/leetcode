package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1920 extends LeetcodeProblem {

    int[] buildArray(int[] _nums) {
        int[] ans = new int[_nums.length];
        for (int i = 0; i < _nums.length; i++) {
            ans[i] = _nums[_nums[i]];
        }
        return ans;
    }

}
