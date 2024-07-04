package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1427 extends LeetcodeProblem {

    String stringShift(String _s, int[][] _shift) {
        StringBuilder sb = new StringBuilder();
        for (int[] move : _shift) {
            sb.setLength(0);
            if (move[0] == 0) {
                sb.append(_s.substring(move[1]))
                  .append(_s, 0, move[1]);
            } else {
                sb.append(_s.substring(_s.length() - move[1]))
                  .append(_s, 0, _s.length() - move[1]);
            }
            _s = sb.toString();
        }
        return _s;
    }

}
