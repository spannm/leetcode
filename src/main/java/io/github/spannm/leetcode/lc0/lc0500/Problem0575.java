package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.stream.Collectors;

class Problem0575 extends LeetcodeProblem {

    int distributeCandies(int[] _candyType) {
        return Math.min(Arrays.stream(_candyType).boxed().collect(Collectors.toSet()).size(), _candyType.length / 2);
    }

}
