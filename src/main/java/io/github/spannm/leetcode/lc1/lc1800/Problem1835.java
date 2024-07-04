package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1835. Find XOR Sum of All Pairs Bitwise AND.
 */
class Problem1835 extends LeetcodeProblem {

    int getXORSum(int[] arr1, int[] arr2) {
        int a = 0;
        int b = 0;
        for (int v : arr1) {
            a ^= v;
        }
        for (int v : arr2) {
            b ^= v;
        }
        return a & b;
    }

}
