package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/valid-number/">65. Valid Number</a>.
 */
class Problem0065 extends LeetcodeProblem {

    boolean isNumber(final String _s) {
        return _s != null
            && !_s.isBlank()
            && _s.matches("(\\s*)[+-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))([eE][+-]?[0-9]+)?(\\s*)");
    }

}
