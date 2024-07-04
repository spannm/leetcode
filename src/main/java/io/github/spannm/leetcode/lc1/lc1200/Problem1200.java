package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1200 extends LeetcodeProblem {

    List<List<Integer>> minimumAbsDifference(int[] _arr) {
        Arrays.sort(_arr);
        int minimumDiff = _arr[1] - _arr[0];
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(_arr[0], _arr[1]));
        for (int i = 1; i < _arr.length - 1; i++) {
            int diff = _arr[i + 1] - _arr[i];
            if (minimumDiff == diff) {
                result.add(List.of(_arr[i], _arr[i + 1]));
            } else if (minimumDiff > diff) {
                minimumDiff = diff;
                result = new ArrayList<>();
                result.add(List.of(_arr[i], _arr[i + 1]));
            }
        }
        return result;
    }

}
