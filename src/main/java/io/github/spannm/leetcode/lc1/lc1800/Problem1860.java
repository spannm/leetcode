package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1860 extends LeetcodeProblem {

    int[] memLeak(int _memory1, int _memory2) {
        int time = 1;
        while (_memory1 >= time || _memory2 >= time) {
            if (_memory1 >= _memory2) {
                _memory1 -= time;
            } else {
                _memory2 -= time;
            }
            time++;
        }
        return new int[] {time, _memory1, _memory2};
    }

}
