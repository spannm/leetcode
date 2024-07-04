package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/sort-array-by-parity/">905. Sort Array By Parity</a>.
 */
class Problem0905 extends LeetcodeProblem {

    int[] sortArrayByParity(int[] _nums) {
        return IntStream.of(_nums).boxed().sorted(Comparator.comparingInt(a -> a % 2)).mapToInt(i -> i).toArray();
    }

}
