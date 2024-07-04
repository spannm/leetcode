package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2275. Largest Combination With Bitwise AND Greater Than Zero.
 */
class Problem2275 extends LeetcodeProblem {

    int largestCombination(int[] _candidates) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int t = 0;
            for (int x : _candidates) {
                t += x >> i & 1;
            }
            ans = Math.max(ans, t);
        }
        return ans;
    }

}
