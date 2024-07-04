package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1446 extends LeetcodeProblem {

    int maxPower(String _s) {
        int max = 0;
        for (int i = 0; i < _s.length(); i++) {
            int start = i;
            while (i + 1 < _s.length() && _s.charAt(i) == _s.charAt(i + 1)) {
                i++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

}
