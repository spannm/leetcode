package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0908 extends LeetcodeProblem {

    int smallestRangeI(int[] _arr, int _k) {
        Arrays.sort(_arr);
        int smallestPlus = _arr[0] + _k;
        int biggestMinus = _arr[_arr.length - 1] - _k;
        int diff = biggestMinus - smallestPlus;
        return Math.max(diff, 0);
    }

}
