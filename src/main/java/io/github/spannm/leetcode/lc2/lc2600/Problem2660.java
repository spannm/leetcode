package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2660. Determine the Winner of a Bowling Game.
 */
class Problem2660 extends LeetcodeProblem {

    @SuppressWarnings("PMD.LinguisticNaming")
    int isWinner(int[] _player1, int[] _player2) {
        int a = f(_player1);
        int b = f(_player2);
        return a > b ? 1 : b > a ? 2 : 0;
    }

    private int f(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            int k = i > 0 && arr[i - 1] == 10 || i > 1 && arr[i - 2] == 10 ? 2 : 1;
            s += k * arr[i];
        }
        return s;
    }

}
