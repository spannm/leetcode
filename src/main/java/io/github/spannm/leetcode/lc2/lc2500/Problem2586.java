package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Set;

class Problem2586 extends LeetcodeProblem {

    int vowelStrings(String[] _words, int _left, int _right) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for (int i = _left; i <= _right; i++) {
            String word = _words[i];
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                count++;
            }
        }
        return count;
    }

}
