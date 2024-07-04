package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1910 extends LeetcodeProblem {

    String removeOccurrences(String _s, String _part) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _s.length(); i++) {
            sb.append(_s.charAt(i));
            if (sb.length() >= _part.length()) {
                if (sb.substring(sb.length() - _part.length()).equals(_part)) {
                    sb.setLength(sb.length() - _part.length());
                }
            }
        }
        return sb.toString();
    }

}
