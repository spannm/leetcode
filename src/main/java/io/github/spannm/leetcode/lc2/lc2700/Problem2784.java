package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2784. Check if Array is Good.
 */
class Problem2784 extends LeetcodeProblem {

    boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int[] cnt = new int[201];
        for (int x : nums) {
            cnt[x]++;
        }
        cnt[n] -= 2;
        for (int i = 1; i < n; i++) {
            cnt[i] -= 1;
        }
        for (int x : cnt) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }

}
