package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Problem0448 extends LeetcodeProblem {

    List<Integer> findDisappearedNumbers(int[] _nums) {
        int max = Arrays.stream(_nums).max().orElse(Integer.MIN_VALUE);
        max = Math.max(max, _nums.length);

        Map<Integer, Integer> map =
            IntStream.rangeClosed(1, max).boxed().collect(Collectors.toMap(k -> k, v -> 0, (v1, v2) -> v1, HashMap::new));

        for (int i : _nums) {
            map.compute(i, (k, v) -> v == null ? 0 : v + 1);
        }

        return map.keySet().stream().filter(k -> map.get(k) == 0).toList();
    }

}
