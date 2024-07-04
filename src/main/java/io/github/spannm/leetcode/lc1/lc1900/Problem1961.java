package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1961 extends LeetcodeProblem {

    boolean isPrefixString(String _s, String[] _words) {
        StringBuilder sb = new StringBuilder();
        for (String word : _words) {
            sb.append(word);
            if (sb.toString().equals(_s)) {
                return true;
            }
        }
        return false;
    }

}
