package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/">1502. Can Make Arithmetic
 * Progression From Sequence</a>.
 */
class Problem1502 extends LeetcodeProblem {

    static boolean canMakeArithmeticProgression(final int[] _arr) {
        Arrays.sort(_arr);
        final int diff = _arr[1] - _arr[0];
        for (int i = 1; i < _arr.length; i++) {
            if (diff != _arr[i] - _arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
