package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2527. Find Xor-Beauty of Array.
 */
class Problem2527 extends LeetcodeProblem {

    int xorBeauty(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }
        return ans;
    }

}
