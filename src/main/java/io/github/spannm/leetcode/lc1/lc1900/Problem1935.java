package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1935 extends LeetcodeProblem {

    @SuppressWarnings("PMD.LinguisticNaming")
    int canBeTypedWords(String _text, String _brokenLetters) {
        String[] words = _text.split(" ");
        int count = 0;
        for (String word : words) {
            boolean broken = false;
            for (char c : word.toCharArray()) {
                if (_brokenLetters.indexOf(c) != -1) {
                    broken = true;
                    break;
                }
            }
            if (!broken) {
                count++;
            }
        }
        return count;
    }

}
