package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/removing-stars-from-a-string/">2390. Removing Stars From a String</a>.
 */
class Problem2390 extends LeetcodeProblem {

    String removeStars(final String _s) {
        if (_s == null || _s.isEmpty()) {
            return _s;
        }

        final StringBuilder sb = new StringBuilder();
        for (char c : _s.toCharArray()) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
