package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1024 extends LeetcodeProblem {

    int videoStitching(int[][] _clips, int _time) {
        Arrays.sort(_clips, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int count = 0;
        int covered = 0;
        for (int i = 0, start = 0; start < _time; count++, start = covered) {
            for (; i < _clips.length && _clips[i][0] <= start; i++) {
                covered = Math.max(covered, _clips[i][1]);
            }
            if (start == covered) {
                return -1;
            }
        }
        return count;
    }

}
