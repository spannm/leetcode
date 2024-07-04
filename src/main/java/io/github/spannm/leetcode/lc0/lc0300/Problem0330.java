package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0330 extends LeetcodeProblem {

    int minPatches(int[] _nums, int _n) {
        int len = _nums.length;
        int idx = 0;
        long misses = 1;
        int patches = 0;
        while (misses <= _n) {
            if (idx < len && _nums[idx] <= misses) {
                misses += _nums[idx++];
            } else {
                misses += misses;
                patches++;
            }
        }
        return patches;
    }

}
