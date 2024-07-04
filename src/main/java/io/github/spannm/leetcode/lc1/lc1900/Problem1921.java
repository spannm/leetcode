package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1921 extends LeetcodeProblem {

    int eliminateMaximum(int[] _dist, int[] _speed) {
        final int len = _dist.length;
        int[] time = new int[len];
        int i = 0;
        for (; i < len; i++) {
            time[i] = (int) Math.ceil(_dist[i] / (float) _speed[i]);
        }
        Arrays.sort(time);
        i = 1;
        for (; i < len; i++) {
            if (i >= time[i]) {
                return i;
            }
        }
        return i;
    }

}
