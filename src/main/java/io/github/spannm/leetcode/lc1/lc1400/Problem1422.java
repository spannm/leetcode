package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1422 extends LeetcodeProblem {

    int maxScore(String _s) {
        int zeroes = _s.charAt(0) == '0' ? 1 : 0;
        int ones = 0;
        for (int i = 1; i < _s.length(); i++) {
            if (_s.charAt(i) == '1') {
                ones++;
            }
        }
        int maxScore = zeroes + ones;
        for (int i = 1; i < _s.length() - 1; i++) {
            if (_s.charAt(i) == '0') {
                zeroes++;
            } else {
                ones--;
            }
            maxScore = Math.max(maxScore, zeroes + ones);
        }
        return maxScore;
    }

}
