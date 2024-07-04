package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0657 extends LeetcodeProblem {

    boolean judgeCircle(String _moves) {
        int hor = 0;
        int vrt = 0;
        for (char c : _moves.toCharArray()) {
            if ('U' == c) {
                vrt++;
            } else if ('D' == c) {
                vrt--;
            } else if ('L' == c) {
                hor--;
            } else if ('R' == c) {
                hor++;
            }
        }
        return vrt == 0 && hor == 0;
    }

}
