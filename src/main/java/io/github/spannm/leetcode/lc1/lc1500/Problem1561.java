package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1561 extends LeetcodeProblem {

    int maxCoins(int[] _piles) {
        Arrays.sort(_piles);
        int j = 0;
        int coins = 0;
        for (int i = _piles.length - 2; i > 0; i -= 2) {
            coins += _piles[i];
            if (++j == _piles.length / 3) {
                return coins;
            }
        }
        return coins;
    }

}
