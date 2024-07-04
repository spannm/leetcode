package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0318 extends LeetcodeProblem {

    int maxProduct(String[] _words) {
        int len = _words.length;
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            String word = _words[i];
            for (int j = 0; j < _words[i].length(); j++) {
                values[i] |= 1 << word.charAt(j) - 'a';
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ((values[i] & values[j]) == 0
                    && _words[i].length() * _words[j].length() > maxProduct) {
                    maxProduct = _words[i].length() * _words[j].length();
                }
            }
        }
        return maxProduct;
    }

}
