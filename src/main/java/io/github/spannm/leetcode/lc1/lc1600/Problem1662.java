package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1662 extends LeetcodeProblem {

    boolean arrayStringsAreEqual(String[] _word1, String[] _word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String word : _word1) {
            sb1.append(word);
        }
        StringBuilder sb2 = new StringBuilder();
        for (String word : _word2) {
            sb2.append(word);
        }
        return sb1.toString().contentEquals(sb2);
    }

}
