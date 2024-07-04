package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0378 extends LeetcodeProblem {

    int kthSmallest(int[][] _matrix, int _k) {
        return Arrays.stream(_matrix).flatMap(row -> Arrays.stream(row).boxed())
            .sorted()
            .limit(_k)
            .mapToInt(i -> i)
            .max().orElse(-1);
    }

}
