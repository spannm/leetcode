package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1754 extends LeetcodeProblem {

    String largestMerge(String _word1, String _word2) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < _word1.length() && j < _word2.length()) {
            if (_word1.substring(i).compareTo(_word2.substring(j)) > 0) {
                sb.append(_word1.charAt(i++));
            } else {
                sb.append(_word2.charAt(j++));
            }
        }
        while (i < _word1.length()) {
            sb.append(_word1.charAt(i++));
        }
        while (j < _word2.length()) {
            sb.append(_word2.charAt(j++));
        }
        return sb.toString();
    }

}
