package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/coin-change-ii/">518. Coin Change II</a>.
 */
class Problem0518 extends LeetcodeProblem {

    int change(final int _amount, int[] _coins) {
        int[] arr = new int[_amount + 1];
        arr[0] = 1;
        for (int c1 : _coins) {
            for (int amt = c1; amt <= _amount; amt++) {
                arr[amt] += arr[amt - c1];
            }
        }
        int result = arr[_amount];

        _coins = null;
        arr = null;
        System.gc();

        return result;
    }

}
