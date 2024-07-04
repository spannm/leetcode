package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2278 extends LeetcodeProblem {

    int percentageLetter(String _s, char _letter) {
        int count = 0;
        for (char c : _s.toCharArray()) {
            if (c == _letter) {
                count++;
            }
        }
        return (int) Math.floor(count * 100.0 / _s.length());
    }

}
