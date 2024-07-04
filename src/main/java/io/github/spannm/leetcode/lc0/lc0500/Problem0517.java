package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0517 extends LeetcodeProblem {

    int findMinMoves(int[] _machines) {
        int total = Arrays.stream(_machines).sum();
        if (total % _machines.length != 0) {
            return -1;
        }
        int avg = total / _machines.length;
        int cnt = 0;
        int max = 0;
        for (int load : _machines) {
            cnt += load - avg;
            max = Math.max(Math.max(max, Math.abs(cnt)), load - avg);
        }
        return max;
    }

}
