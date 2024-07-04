package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2185 extends LeetcodeProblem {

    int prefixCount(String[] _words, String _pref) {
        int count = 0;
        for (String word : _words) {
            if (word.startsWith(_pref)) {
                count++;
            }
        }
        return count;
    }

}
