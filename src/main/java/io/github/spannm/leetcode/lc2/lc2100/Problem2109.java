package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2109 extends LeetcodeProblem {

    String addSpaces(String _s, int[] _spaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < _s.length(); i++) {
            if (j < _spaces.length && i == _spaces[j]) {
                sb.append(" ");
                j++;
            }
            sb.append(_s.charAt(i));
        }
        return sb.toString();
    }

}
