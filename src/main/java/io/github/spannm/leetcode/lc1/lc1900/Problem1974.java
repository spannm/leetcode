package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1974 extends LeetcodeProblem {

    int minTimeToType(String _word) {
        int min = 0;
        char curr = 'a';
        for (int i = 0; i < _word.length(); i++) {
            int diff = curr - _word.charAt(i);
            curr = _word.charAt(i);
            min += Math.min(diff + 26, Math.min(Math.abs(diff), 26 - diff));
            min++;
        }
        return min;
    }

}
