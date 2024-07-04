package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1189 extends LeetcodeProblem {

    int maxNumberOfBalloons(String _text) {
        int[] counts = new int[26];
        for (char c : _text.toCharArray()) {
            counts[c - 'a']++;
        }
        return Math.min(counts[0], Math.min(counts[1], Math.min(counts[11] / 2, Math.min(counts[14] / 2, counts[13]))));
    }

}
