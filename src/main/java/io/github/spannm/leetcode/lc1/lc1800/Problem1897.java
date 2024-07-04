package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1897 extends LeetcodeProblem {

    boolean makeEqual(String[] _words) {
        int len = _words.length;
        int[] counts = new int[26];
        for (String word : _words) {
            for (char c : word.toCharArray()) {
                counts[c - 'a']++;
            }
        }
        for (int c : counts) {
            if (c % len != 0) {
                return false;
            }
        }
        return true;
    }

}
