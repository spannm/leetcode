package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2432 extends LeetcodeProblem {

    int hardestWorker(int _n, int[][] _logs) {
        int startTime = 0;
        int maxDuration = 0;
        int result = 0;
        for (int[] log : _logs) {
            int duration = log[1] - startTime;
            startTime = log[1];
            if (duration > maxDuration) {
                result = log[0];
                maxDuration = duration;
            } else if (duration == maxDuration) {
                if (log[0] < result) {
                    result = log[0];
                }
            }
        }
        return result;
    }

}
