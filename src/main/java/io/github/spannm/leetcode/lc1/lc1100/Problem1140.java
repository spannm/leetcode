package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/stone-game-ii/">1140. Stone Game II</a>.
 */
class Problem1140 extends LeetcodeProblem {

    static int stoneGameII(int[] _piles) {
        final int len = _piles.length;
        final int[] prefixSum = new int[len];
        prefixSum[len - 1] = _piles[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            prefixSum[i] = prefixSum[i + 1] + _piles[i];
        }

        final int[][] memo = new int[len][len];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(_piles, prefixSum, memo, 0, 1);
    }

    static int dfs(int[] _piles, int[] _prefixSum, int[][] _memo, int _i, int _m) {
        if (_i == _piles.length) {
            return 0;
        } else if (2 * _m >= _piles.length - _i) {
            return _prefixSum[_i];
        } else if (_memo[_i][_m] != -1) {
            return _memo[_i][_m];
        }

        int maxStones = 0;
        for (int x = 1; x <= 2 * _m; x++) {
            int remainStones = _prefixSum[_i] - dfs(_piles, _prefixSum, _memo, _i + x, Math.max(_m, x));
            maxStones = Math.max(maxStones, remainStones);
        }

        _memo[_i][_m] = maxStones;
        return maxStones;
    }

}
