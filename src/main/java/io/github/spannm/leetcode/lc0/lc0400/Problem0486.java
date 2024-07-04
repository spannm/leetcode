package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/predict-the-winner/">486. Predict the Winner</a>.
 */
class Problem0486 extends LeetcodeProblem {

    boolean predictTheWinner(final int[] _nums) {
        final int len = _nums.length;
        return predict(_nums, 0, len - 1, len) >= 0;
    }

    static int predict(final int[] _nums, int _l, int _r, int _len) {
        if (_l == _r) {
            return _nums[_l];
        }
        int left = _nums[_l] - predict(_nums, _l + 1, _r, _len);
        int right = _nums[_r] - predict(_nums, _l, _r - 1, _len);
        return Math.max(left, right);
    }

}
