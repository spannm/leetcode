package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.stream.IntStream;

class Problem0561 extends LeetcodeProblem {

    int arrayPairSum(int[] _nums) {
        Arrays.sort(_nums);
        return IntStream.range(0, _nums.length).filter(i -> i % 2 == 0).map(i -> _nums[i]).sum();
    }

}
