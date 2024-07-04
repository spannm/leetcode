package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0717 extends LeetcodeProblem {

    boolean isOneBitCharacter(int[] _bits) {
        int len = _bits.length;
        int i = 0;
        while (i < len - 1) {
            if (_bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i == len - 1;
    }

}
