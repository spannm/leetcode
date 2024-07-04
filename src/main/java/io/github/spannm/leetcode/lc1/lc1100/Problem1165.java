package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1165 extends LeetcodeProblem {

    int calculateTime(String _keyboard, String _word) {
        int time = 0;
        int fromIndex = 0;
        for (char c : _word.toCharArray()) {
            int fingerMoves = Math.abs(fromIndex - _keyboard.indexOf(c));
            fromIndex = _keyboard.indexOf(c);
            time += fingerMoves;
        }
        return time;
    }

}
