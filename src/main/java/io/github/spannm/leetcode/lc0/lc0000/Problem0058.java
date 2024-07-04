package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/length-of-last-word/">58. Length of Last Word</a>.
 */
class Problem0058 extends LeetcodeProblem {

    int lengthOfLastWord(final String _s) {
        final int len = _s.length();
        boolean start = false;
        int count = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (_s.charAt(i) == ' ') {
                if (start) {
                    return count;
                }
            } else {
                start = true;
                count++;
            }
        }
        return count;
    }

}
