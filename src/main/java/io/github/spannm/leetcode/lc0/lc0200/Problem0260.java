package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Problem0260 extends LeetcodeProblem {

    int[] singleNumber(int[] _nums) {
        return Arrays.stream(_nums).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()))
            .entrySet().stream()
            .filter(e -> 1 == e.getValue()).mapToInt(Map.Entry::getKey).toArray();
    }

}
