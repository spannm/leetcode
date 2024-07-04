package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

class Problem0422 extends LeetcodeProblem {

    boolean validWordSquare(List<String> _words) {
        for (int i = 0; i < _words.size(); i++) {
            String word = _words.get(i);
            for (int j = 0; j < word.length(); j++) {
                if (j >= _words.size() || i >= _words.get(j).length() || word.charAt(j) != _words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
