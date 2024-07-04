package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0453 extends LeetcodeProblem {

    int minMoves(int[] _nums) {
        if (_nums.length == 0) {
            return 0;
        }
        int min = Arrays.stream(_nums).min().orElse(Integer.MIN_VALUE);
        return Arrays.stream(_nums).map(n -> n - min).sum();
    }

}
