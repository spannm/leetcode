package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii/">45. Jump Game II</a>.
 */
class Problem0045 extends LeetcodeProblem {

    int jump(final int[] _nums) {
        final int len = _nums.length;
        int jumps = 0;
        int lastJumpMax = 0;
        int currJumpMax = 0;
        for (int i = 0; i < len - 1; i++) {
            currJumpMax = Math.max(currJumpMax, i + _nums[i]);
            if (i == lastJumpMax) {
                jumps++;
                lastJumpMax = currJumpMax;
            }
            if (lastJumpMax >= len) {
                break;
            }
        }
        return jumps;
    }

}
