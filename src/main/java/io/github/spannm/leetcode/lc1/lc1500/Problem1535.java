package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1535 extends LeetcodeProblem {

    int getWinner(int[] _arr, int _k) {
        int winner = _arr[0];
        int winTimes = 0;
        for (int i = 1; i < _arr.length; i++) {
            if (_arr[i] > winner) {
                winner = _arr[i];
                winTimes = 1;
            } else {
                winTimes++;
            }

            if (winTimes >= _k) {
                return winner;
            }
        }
        return winner;
    }

}
