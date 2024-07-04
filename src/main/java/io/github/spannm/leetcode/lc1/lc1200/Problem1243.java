package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Problem1243 extends LeetcodeProblem {

    List<Integer> transformArray(int[] _arr) {
        int[] copy;
        do {
            copy = Arrays.copyOf(_arr, _arr.length);
            for (int i = 1; i < _arr.length - 1; i++) {
                if (copy[i] < copy[i - 1] && copy[i] < copy[i + 1]) {
                    _arr[i]++;
                } else if (copy[i] > copy[i - 1] && copy[i] > copy[i + 1]) {
                    _arr[i]--;
                }
            }
        } while (!Arrays.equals(copy, _arr));
        return Arrays.stream(_arr)
            .boxed()
            .collect(Collectors.toList());
    }

}
