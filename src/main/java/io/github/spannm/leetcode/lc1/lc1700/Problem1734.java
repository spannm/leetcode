package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1734. Decode XORed Permutation.
 */
class Problem1734 extends LeetcodeProblem {

    int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n - 1; i += 2) {
            a ^= encoded[i];
        }
        for (int i = 1; i <= n; i++) {
            b ^= i;
        }
        int[] perm = new int[n];
        perm[n - 1] = a ^ b;
        for (int i = n - 2; i >= 0; i--) {
            perm[i] = encoded[i] ^ perm[i + 1];
        }
        return perm;
    }

}
