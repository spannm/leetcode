package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

class Problem1550 extends LeetcodeProblem {

    boolean threeConsecutiveOdds(int[] _arr) {
        return IntStream.range(0, _arr.length - 2).anyMatch(i -> _arr[i] % 2 == 1 && _arr[i + 1] % 2 == 1 && _arr[i + 2] % 2 == 1);
    }

}
