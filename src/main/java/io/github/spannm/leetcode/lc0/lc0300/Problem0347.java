package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">347. Top K Frequent Elements</a>.
 */
class Problem0347 extends LeetcodeProblem {

    static int[] topKFrequent(final int[] _nums, final int _k) {
        return _k == _nums.length
            ? _nums
            : Arrays.stream(_nums).boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.summingInt(i -> 1))).entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(_k)
                .map(Map.Entry::getKey)
                .mapToInt(i -> i)
                .toArray();
    }

}
