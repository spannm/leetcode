package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1247. Minimum Swaps to Make Strings Equal.
 */
class Problem1247 extends LeetcodeProblem {

    int minimumSwap(String _s1, String _s2) {
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < _s1.length(); i++) {
            char a = _s1.charAt(i);
            char b = _s2.charAt(i);
            if (a < b) {
                xy++;
            }
            if (a > b) {
                yx++;
            }
        }
        if ((xy + yx) % 2 == 1) {
            return -1;
        }
        return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }

}
