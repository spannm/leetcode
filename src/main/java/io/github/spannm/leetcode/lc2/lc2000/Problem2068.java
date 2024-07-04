package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2068 extends LeetcodeProblem {

    boolean checkAlmostEquivalent(String _word1, String _word2) {
        int[] count = new int[26];
        for (char c : _word1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : _word2.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (Math.abs(i) > 3) {
                return false;
            }
        }
        return true;
    }

}
