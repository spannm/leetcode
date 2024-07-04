package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1217 extends LeetcodeProblem {

    int minCostToMoveChips(int[] _position) {
        int chipsAtOddPosition = 0;
        int chipsAtEvenPosition = 0;
        for (int element : _position) {
            if (element % 2 == 0) {
                chipsAtEvenPosition++;
            } else {
                chipsAtOddPosition++;
            }
        }
        return Math.min(chipsAtEvenPosition, chipsAtOddPosition);
    }

}
