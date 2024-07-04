package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/jump-game/">55. Jump Game</a>.
 */
class Problem0055 extends LeetcodeProblem {

    boolean canJump(int[] _nums) {
        int maxReachableIdx = 0; // initially 0
        final int len = _nums.length;
        final int maxIndex = len - 1;
        for (int idx = 0; idx < len; idx++) {
            if (idx > maxReachableIdx) {
                return false; // out of reach
            }
            maxReachableIdx = Math.max(maxReachableIdx, idx + _nums[idx]);
            if (maxReachableIdx >= maxIndex) {
                return true; // done
            }
        }
        return true;
    }

}
