package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1051 extends LeetcodeProblem {

    int heightChecker(int[] _heights) {
        int count = _heights.length;
        int[] ordered = Arrays.copyOf(_heights, count);
        Arrays.sort(ordered);
        int result = 0;
        for (int i = 0; i < count; i++) {
            if (_heights[i] != ordered[i]) {
                result++;
            }
        }
        return result;
    }

}
