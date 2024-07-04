package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/merge-strings-alternately/">1768. Merge Strings Alternately</a>.
 */
class Problem1768 extends LeetcodeProblem {

    String mergeAlternately(String _word1, String _word2) {
        if (_word1 == null) {
            return _word2;
        } else if (_word2 == null) {
            return _word1;
        }
        final int len1 = _word1.length();
        final int len2 = _word2.length();
        if (len1 == 0) {
            return _word2;
        } else if (len2 == 0) {
            return _word1;
        }

        final int minLen = Math.min(len1, len2);
        final StringBuilder sb = new StringBuilder(len1 + len2);
        int i = 0;
        for (; i < minLen; i++) {
            sb.append(_word1.charAt(i))
                .append(_word2.charAt(i));
        }
        if (len1 != len2) {
            if (len1 > len2) {
                sb.append(_word1.substring(i));
            } else {
                sb.append(_word2.substring(i));
            }
        }

        return sb.toString();
    }

}
