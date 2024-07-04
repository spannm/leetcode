package io.github.spannm.leetcode.lc3.lc3200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3201. Find the Maximum Length of Valid Subsequence I.
 */
class Problem3201 extends LeetcodeProblem {

    int maximumLength(int[] _nums) {
        int[][] mem = new int[2][2];
        int result = 0;
        for (int n : _nums) {
            n %= 2;
            for (int i = 0; i < 2; i++) {
                int y = (i - n + 2) % 2;
                mem[n][y] = mem[y][n] + 1;
                result = Math.max(result, mem[n][y]);
            }
        }
        return result;
    }

}
