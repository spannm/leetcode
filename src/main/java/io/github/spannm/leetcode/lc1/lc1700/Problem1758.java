package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1758 extends LeetcodeProblem {

    int minOperations(String _s) {
        int ops1 = 0;
        int ops2 = 0;

        for (int i = 0; i < _s.length(); i++) {
            if (i % 2 == 0) {
                if (_s.charAt(i) == '1') {
                    ops1++;
                } else {
                    ops2++;
                }
            } else if (_s.charAt(i) == '0') {
                ops1++;
            } else {
                ops2++;
            }
        }

        return Math.min(ops1, ops2);
    }

}
