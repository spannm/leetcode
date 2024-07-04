package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0390 extends LeetcodeProblem {

    int lastRemaining(int _n) {
        int remaining = _n;
        int start = 1;
        int step = 2;
        boolean forward = true;
        while (remaining > 1) {
            remaining /= 2;
            if (forward) {
                start = start + step * remaining - step / 2;
            } else {
                start = start - step * remaining + step / 2;
            }
            step *= 2;
            forward = !forward;
        }
        return start;
    }

}
