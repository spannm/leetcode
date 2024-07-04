package io.github.spannm.leetcode.lc3.lc3200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3202. Find the Maximum Length of Valid Subsequence II.
 */
class Problem3202 extends LeetcodeProblem {

    int maximumLength(int[] _nums, int _k) {
        int[][] mem = new int[_k][_k];
        int result = 0;
        for (int n : _nums) {
            n %= _k;
            for (int j = 0; j < _k; j++) {
                int y = (j - n + _k) % _k;
                mem[n][y] = mem[y][n] + 1;
                result = Math.max(result, mem[n][y]);
            }
        }
        return result;
    }

}
