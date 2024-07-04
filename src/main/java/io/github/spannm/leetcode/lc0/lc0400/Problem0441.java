package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0441 extends LeetcodeProblem {

    int arrangeCoins(int _coins) {
        if (_coins < 2) {
            return _coins;
        }
        int row = 0;
        int count = 0;
        long sum = 0;
        while (sum < _coins) {
            row += 1;
            sum += row;
            count++;
        }
        if (sum != _coins) {
            count--;
        }
        return count;
    }

}
