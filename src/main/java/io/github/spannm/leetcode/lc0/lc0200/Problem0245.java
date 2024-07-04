package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0245 extends LeetcodeProblem {

    int shortestWordDistance(String[] _words, String _word1, String _word2) {
        int p1 = -1;
        int p2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < _words.length; i++) {
            if (_words[i].equals(_word1)) {
                if (_word1.equals(_word2)) {
                    if (p1 != -1 && i - p1 < min) {
                        min = i - p1;
                    }
                    p1 = i;
                } else {
                    p1 = i;
                    if (p2 != -1 && p1 - p2 < min) {
                        min = p1 - p2;
                    }
                }
            } else if (_words[i].equals(_word2)) {
                p2 = i;
                if (p1 != -1 && p2 - p1 < min) {
                    min = p2 - p1;
                }
            }
        }
        return min;
    }

}
