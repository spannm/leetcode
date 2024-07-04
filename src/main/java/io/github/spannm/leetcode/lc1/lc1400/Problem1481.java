package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Problem1481 extends LeetcodeProblem {

    int findLeastNumOfUniqueInts(int[] _arr, int _k) {
        Map<Integer, Integer> unSortedMap = Arrays.stream(_arr).boxed().collect(Collectors.groupingBy(i -> i, Collectors.summingInt(i -> 1)));
        List<Integer> values = unSortedMap.values().stream().sorted().toList();

        int leastUniq = 0;
        for (int count : values) {
            if (_k >= count) {
                _k -= count;
            } else {
                leastUniq++;
            }
        }
        return leastUniq;
    }

}
