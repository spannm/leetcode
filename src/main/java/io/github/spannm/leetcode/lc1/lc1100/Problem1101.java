package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1101. The Earliest Moment When Everyone Become Friends.
 */
class Problem1101 extends LeetcodeProblem {

    private int[] p;

    int earliestAcq(int[][] _logs, int _n) {
        Arrays.sort(_logs, Comparator.comparingInt(a -> a[0]));
        p = new int[_n];
        for (int i = 0; i < _n; i++) {
            p[i] = i;
        }
        for (int[] log : _logs) {
            int t = log[0];
            int x = log[1];
            int y = log[2];
            if (find(x) == find(y)) {
                continue;
            }
            p[find(x)] = find(y);
            if (--_n == 1) {
                return t;
            }
        }
        return -1;
    }

    private int find(int _x) {
        if (p[_x] != _x) {
            p[_x] = find(p[_x]);
        }
        return p[_x];
    }

}
