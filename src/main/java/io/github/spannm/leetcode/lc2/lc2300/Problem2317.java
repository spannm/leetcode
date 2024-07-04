package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2317. Maximum XOR After Operations.
 */
class Problem2317 extends LeetcodeProblem {

    int maximumXOR(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans |= x;
        }
        return ans;
    }

}
