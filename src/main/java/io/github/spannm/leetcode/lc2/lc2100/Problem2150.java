package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Problem2150 extends LeetcodeProblem {

    List<Integer> findLonely(int[] _nums) {
        Map<Integer, Long> counts = Arrays.stream(_nums).boxed()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        return counts.entrySet().stream()
            .filter(e -> e.getValue() <= 1 && !counts.containsKey(e.getKey() - 1) && !counts.containsKey(e.getKey() + 1))
            .map(Map.Entry::getKey)
            .toList();
    }

}
