package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1221 extends LeetcodeProblem {

    int balancedStringSplit(String _s) {
        int i = 0;
        int balancedCount = 0;
        int lCount = 0;
        int rCount = 0;
        while (i < _s.length()) {
            if (_s.charAt(i) == 'L') {
                lCount++;
            } else {
                rCount++;
            }
            i++;
            if (lCount != 0 && lCount == rCount) {
                lCount = 0;
                rCount = 0;
                balancedCount++;
            }
        }
        return balancedCount;
    }

}
