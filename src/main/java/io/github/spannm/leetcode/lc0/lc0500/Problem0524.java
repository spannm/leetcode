package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

class Problem0524 extends LeetcodeProblem {

    String findLongestWord(String _s, List<String> _d) {
        _d.sort((a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for (String dictWord : _d) {
            int i = 0;
            for (char c : _s.toCharArray()) {
                if (i < dictWord.length() && dictWord.charAt(i) == c) {
                    i++;
                }
            }
            if (i == dictWord.length()) {
                return dictWord;
            }
        }
        return "";
    }

}
