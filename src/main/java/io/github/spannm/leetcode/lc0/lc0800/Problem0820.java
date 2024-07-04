package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

class Problem0820 extends LeetcodeProblem {

    int minimumLengthEncoding(String[] _words) {
        Arrays.sort(_words, Comparator.comparingInt(String::length));
        boolean[] removed = new boolean[_words.length];
        for (int j = _words.length - 2; j >= 0; j--) {
            for (int i = j + 1; i < _words.length; i++) {
                if (!removed[i]) {
                    if (_words[i].endsWith(_words[j])) {
                        removed[j] = true;
                        break;
                    }
                }
            }
        }
        int len = 0;
        for (int i = 0; i < _words.length; i++) {
            if (!removed[i]) {
                len += _words[i].length();
                len++;
            }
        }
        return len;
    }

}
