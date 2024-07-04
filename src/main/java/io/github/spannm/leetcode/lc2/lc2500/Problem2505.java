package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2505. Bitwise OR of All Subsequence Sums.
 */
class Problem2505 extends LeetcodeProblem {

    long subsequenceSumOr(int[] nums) {
        long[] cnt = new long[64];
        long ans = 0;
        for (int v : nums) {
            for (int i = 0; i < 31; i++) {
                if ((v >> i & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        for (int i = 0; i < 63; i++) {
            if (cnt[i] > 0) {
                ans |= 1L << i;
            }
            cnt[i + 1] += cnt[i] / 2;
        }
        return ans;
    }

}
