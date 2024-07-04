package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0757 extends LeetcodeProblem {

    int intersectionSizeTwo(int[][] _intervals) {
        Arrays.sort(_intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int count = 0;
        int startTime = Integer.MIN_VALUE;
        int endTime = Integer.MIN_VALUE;

        for (int[] interval : _intervals) {
            if (startTime >= interval[0]) {
                continue;
            } else if (endTime >= interval[0]) {
                startTime = endTime;
                endTime = interval[1];
                count += 1;
            } else {
                startTime = interval[1] - 1;
                endTime = interval[1];
                count += 2;
            }
        }
        return count;
    }

}
