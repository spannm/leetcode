package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.stream.Collectors;

class Problem1941 extends LeetcodeProblem {

    boolean areOccurrencesEqual(String _s) {
        int[] counts = new int[26];
        char[] charArray = _s.toCharArray();
        for (char c : charArray) {
            counts[c - 'a']++;
        }
        return Arrays.stream(counts).filter(i -> i != 0).boxed().collect(Collectors.toSet()).size() == 1;
    }

}
