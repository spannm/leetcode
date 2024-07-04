package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1759 extends LeetcodeProblem {

    int countHomogenous(String _s) {
        int total = 0;
        int count = 0;
        for (int i = 0; i < _s.length(); i++) {
            if (i > 0 && _s.charAt(i) == _s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            total = (total + count) % 1000000007;
        }
        return total;
    }

}
