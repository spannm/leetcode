package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2917. Find the K-or of an Array.
 */
class Problem2917 extends LeetcodeProblem {

    int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int x : nums) {
                cnt += x >> i & 1;
            }
            if (cnt >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

}
