package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0276 extends LeetcodeProblem {

    int numWays(int _n, int _k) {
        if (_n == 0) {
            return 0;
        } else if (_n == 1) {
            return _k;
        }
        int sameColorCnt = _k;
        int diffColorCnt = _k * (_k - 1);
        for (int i = 2; i < _n; i++) {
            int temp = diffColorCnt;
            diffColorCnt = (diffColorCnt + sameColorCnt) * (_k - 1);
            sameColorCnt = temp;
        }
        return sameColorCnt + diffColorCnt;
    }

}
