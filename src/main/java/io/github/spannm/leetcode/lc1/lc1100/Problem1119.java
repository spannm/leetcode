package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Set;

class Problem1119 extends LeetcodeProblem {

    String removeVowels(String _s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        StringBuilder sb = new StringBuilder();
        for (char c : _s.toCharArray()) {
            if (!vowels.contains(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
