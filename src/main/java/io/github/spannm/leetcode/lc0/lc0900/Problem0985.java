package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0985 extends LeetcodeProblem {

    int[] sumEvenAfterQueries(int[] _arr, int[][] _queries) {
        int[] result = new int[_arr.length];
        for (int i = 0; i < _arr.length; i++) {
            int col = _queries[i][1];
            _arr[col] = _arr[col] + _queries[i][0];
            result[i] = computeEvenSum(_arr);
        }
        return result;
    }

    private int computeEvenSum(int[] _arr) {
        return Arrays.stream(_arr).filter(num -> num % 2 == 0).sum();
    }

}
