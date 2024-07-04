package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1816 extends LeetcodeProblem {

    String truncateSentence(String _s, int _k) {
        String[] words = _s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _k; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.substring(0, sb.toString().length() - 1);
    }

}
