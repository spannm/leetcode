package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1347 extends LeetcodeProblem {

    int minSteps(String _s, String _t) {
        int[] counts = new int[26];
        for (char c : _s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : _t.toCharArray()) {
            if (counts[c - 'a'] > 0) {
                counts[c - 'a']--;
            }
        }
        return Arrays.stream(counts).sum();
    }

}
