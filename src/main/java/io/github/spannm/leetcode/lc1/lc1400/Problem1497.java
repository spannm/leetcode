package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1497. Check If Array Pairs Are Divisible by k.
 */
class Problem1497 extends LeetcodeProblem {

    boolean canArrange(int[] arr, int k) {
        int[] cnt = new int[k];
        for (int x : arr) {
            ++cnt[(x % k + k) % k];
        }
        for (int i = 1; i < k; i++) {
            if (cnt[i] != cnt[k - i]) {
                return false;
            }
        }
        return cnt[0] % 2 == 0;
    }

}
