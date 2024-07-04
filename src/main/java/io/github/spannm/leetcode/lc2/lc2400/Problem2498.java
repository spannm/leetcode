package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2498. Frog Jump II.
 */
class Problem2498 extends LeetcodeProblem {

    int maxJump(int[] stones) {
        int ans = stones[1] - stones[0];
        for (int i = 2; i < stones.length; i++) {
            ans = Math.max(ans, stones[i] - stones[i - 2]);
        }
        return ans;
    }

}
