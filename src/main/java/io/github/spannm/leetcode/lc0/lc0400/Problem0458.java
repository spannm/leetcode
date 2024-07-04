package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0458 extends LeetcodeProblem {

    int poorPigs(int _buckets, int _minutesToDie, int _minutesToTest) {
        if (_buckets-- == 1) {
            return 0;
        }
        int base = _minutesToTest / _minutesToDie + 1;
        int count = 0;
        while (_buckets > 0) {
            _buckets /= base;
            count++;
        }
        return count;
    }

}
