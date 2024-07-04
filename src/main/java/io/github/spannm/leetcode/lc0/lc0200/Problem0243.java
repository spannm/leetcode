package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0243 extends LeetcodeProblem {

    int shortestDistance(String[] _words, String _word1, String _word2) {
        int p = -1;
        int q = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < _words.length; i++) {
            if (_words[i].equals(_word1)) {
                p = i;
            }
            if (_words[i].equals(_word2)) {
                q = i;
            }
            if (p != -1 && q != -1) {
                min = Math.min(min, Math.abs(p - q));
            }
        }
        return min;

    }

}
