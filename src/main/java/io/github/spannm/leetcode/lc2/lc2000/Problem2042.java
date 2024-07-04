package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2042 extends LeetcodeProblem {

    boolean areNumbersAscending(String _s) {
        String[] words = _s.split("\\ ");
        int prev = 0;
        for (String word : words) {
            if (Character.isDigit(word.charAt(0))) {
                if (Integer.parseInt(word) <= prev) {
                    return false;
                } else {
                    prev = Integer.parseInt(word);
                }
            }
        }
        return true;
    }

}
