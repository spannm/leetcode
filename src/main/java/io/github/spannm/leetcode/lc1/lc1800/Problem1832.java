package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem1832 extends LeetcodeProblem {

    boolean checkIfPangram(String _sentence) {
        Set<Character> alphabet = new HashSet<>();
        for (char c : _sentence.toCharArray()) {
            alphabet.add(c);
        }
        return alphabet.size() == 26;
    }

}
