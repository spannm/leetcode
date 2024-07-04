package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0387 extends LeetcodeProblem {

    static int firstUniqChar(String _s) {
        int[] freq = new int[26];
        for (int i = 0; i < _s.length(); i++) {
            freq[_s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < _s.length(); i++) {
            if (freq[_s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
