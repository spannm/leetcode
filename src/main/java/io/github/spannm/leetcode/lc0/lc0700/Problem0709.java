package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 709. To Lower Case.
 */
class Problem0709 extends LeetcodeProblem {

    String toLowerCase(String _s) {
        char[] cs = _s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= 'A' && cs[i] <= 'Z') {
                cs[i] |= 32;
            }
        }
        return String.valueOf(cs);
    }

}
