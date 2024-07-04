package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2114 extends LeetcodeProblem {

    int mostWordsFound(String[] _sentences) {
        int max = 0;
        for (String sentence : _sentences) {
            max = Math.max(max, sentence.split("\\ ").length);
        }
        return max;
    }

}
