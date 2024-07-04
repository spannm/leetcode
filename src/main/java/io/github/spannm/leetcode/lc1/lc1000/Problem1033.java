package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1033 extends LeetcodeProblem {

    int[] numMovesStones(int _pos1, int _pos2, int _pos3) {
        int[] t = {_pos1, _pos2, _pos3};
        Arrays.sort(t);

        int min = minMoves(t[0], t[1], t[2]);
        int max = t[2] - t[0] - 2;

        return new int[] {min, max};
    }

    private static int minMoves(int _pos1, int _pos2, int _pos3) {
        if (_pos1 + 1 == _pos2 && _pos2 + 1 == _pos3) {
            return 0;
        } else if (_pos2 - _pos1 <= 2 || _pos3 - _pos2 <= 2) {
            return 1;
        }
        return 2;
    }

}
