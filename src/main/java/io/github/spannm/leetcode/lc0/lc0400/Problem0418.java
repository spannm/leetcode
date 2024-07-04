package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0418 extends LeetcodeProblem {

    int wordsTyping(String[] _sentence, int _rows, int _cols) {
        String s = String.join(" ", _sentence) + " ";
        int start = 0;
        int l = s.length();
        for (int i = 0; i < _rows; i++) {
            start += _cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % l) != ' ') {
                    start--;
                }
            }
        }
        return start / s.length();
    }

}
