package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0734 extends LeetcodeProblem {

    boolean areSentencesSimilar(String[] _words1, String[] _words2, String[][] _pairs) {
        if (_words1.length != _words2.length) {
            return false;
        }
        for (int i = 0; i < _words1.length; i++) {
            if (!isSimilar(_words1[i], _words2[i], _pairs)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSimilar(String _word1, String _word2, String[][] _pairs) {
        if (_word1.equals(_word2)) {
            return true;
        }
        for (String[] pair : _pairs) {
            if (pair[0].equals(_word1) && pair[1].equals(_word2) || pair[0].equals(_word2) && pair[1].equals(_word1)) {
                return true;
            }
        }
        return false;
    }

}
