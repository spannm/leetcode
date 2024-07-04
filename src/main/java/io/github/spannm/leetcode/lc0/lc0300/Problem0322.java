package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0322 extends LeetcodeProblem {

    int coinChange(int[] _coins, int _amount) {
        return _amount < 1 ? 0 : coinChange(_coins, _amount, new int[_amount]);
    }

    private static int coinChange(int[] _coins, int _rem, int[] _count) {
        if (_rem < 0) {
            return -1;
        } else if (_rem == 0) {
            return 0;
        } else if (_count[_rem - 1] != 0) {
            return _count[_rem - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : _coins) {
            int res = coinChange(_coins, _rem - coin, _count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        _count[_rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return _count[_rem - 1];
    }

}
