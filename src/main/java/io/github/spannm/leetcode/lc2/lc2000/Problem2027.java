package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2027 extends LeetcodeProblem {

    int minimumMoves(String _s) {
        int moves = 0;
        for (int i = 0; i < _s.length();) {
            if (_s.charAt(i) == 'O') {
                i++;
                continue;
            }
            String candidate = i + 3 <= _s.length() ? _s.substring(i, i + 3) : _s.substring(i);
            if (candidate.contains("X")) {
                moves++;
                i += 3;
            } else {
                i++;
            }
        }
        return moves;
    }

}
