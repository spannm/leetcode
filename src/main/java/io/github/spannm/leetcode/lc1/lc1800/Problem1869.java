package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1869 extends LeetcodeProblem {

    boolean checkZeroOnes(String _s) {
        int zeroes = 0;
        int ones = 0;
        for (int i = 0; i < _s.length();) {
            int start = i;
            while (i < _s.length() && _s.charAt(i) == '0') {
                i++;
            }
            if (i > start) {
                zeroes = Math.max(zeroes, i - start);
            }
            start = i;
            while (i < _s.length() && _s.charAt(i) == '1') {
                i++;
            }
            if (i > start) {
                ones = Math.max(ones, i - start);
            }
        }
        return ones > zeroes;
    }

}
