package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.stream.IntStream;

class Problem1055 extends LeetcodeProblem {

    int fixedPoint(int[] _arr) {
        return IntStream.range(0, _arr.length).filter(i -> _arr[i] == i).findFirst().orElse(-1);
    }

}
