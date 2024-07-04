package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1180 extends LeetcodeProblem {

    int countLetters(String _s) {
        int count = 0;
        for (int i = 0, j = 1; j < _s.length() && i <= j;) {
            while (j < _s.length() && _s.charAt(i) == _s.charAt(j)) {
                j++;
            }
            count += countTimes(_s.substring(i, j));
            i += _s.substring(i, j).length();
        }
        return count;
    }

    private int countTimes(String _str) {
        int len = _str.length();
        int times = 0;
        while (len > 0) {
            times += len--;
        }
        return times;
    }

}
