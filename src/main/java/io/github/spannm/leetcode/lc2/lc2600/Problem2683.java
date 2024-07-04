package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2683. Neighboring Bitwise XOR.
 */
class Problem2683 extends LeetcodeProblem {

    boolean doesValidArrayExist(int[] derived) {
        int s = 0;
        for (int x : derived) {
            s ^= x;
        }
        return s == 0;
    }

}
