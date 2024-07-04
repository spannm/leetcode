package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem2706 extends LeetcodeProblem {

    int buyChoco(int[] _prices, int _money) {
        Arrays.sort(_prices);
        if (_prices[0] + _prices[1] > _money) {
            return _money;
        } else {
            return _money - _prices[0] - _prices[1];
        }
    }

}
