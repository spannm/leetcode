package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0494 extends LeetcodeProblem {

    int findTargetSumWays(int[] _nums, int _target) {
        return find(0, _nums, _target);
    }

    static int find(int _p, int[] _nums, int _target) {
        if (_p == _nums.length) {
            return _target == 0 ? 1 : 0;
        }
        return find(_p + 1, _nums, _target + _nums[_p])
            + find(_p + 1, _nums, _target - _nums[_p]);
    }

}
