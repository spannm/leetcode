package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1455 extends LeetcodeProblem {

    @SuppressWarnings("PMD.LinguisticNaming")
    int isPrefixOfWord(String _sentence, String _searchWord) {
        String[] words = _sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(_searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }

}
