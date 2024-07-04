package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0789 extends LeetcodeProblem {

    boolean escapeGhosts(int[][] _ghosts, int[] _target) {
        int[] currPos = {0, 0};
        int selfDist = getDist(currPos, _target);

        for (int[] ghost : _ghosts) {
            int ghostDist = getDist(ghost, _target);
            if (ghostDist <= selfDist) {
                return false;
            }
        }
        return true;
    }

    private int getDist(int[] _p1, int[] _p2) {
        return Math.abs(_p1[0] - _p2[0]) + Math.abs(_p1[1] - _p2[1]);
    }

}
