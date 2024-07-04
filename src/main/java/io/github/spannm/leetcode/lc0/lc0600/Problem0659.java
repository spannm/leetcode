package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Problem0659 extends LeetcodeProblem {

    boolean isPossible(int[] _nums) {
        Map<Integer, Integer> freqMap = Arrays.stream(_nums)
            .boxed()
            .collect(Collectors.groupingBy(i -> i, Collectors.summingInt(i -> 1)));

        Map<Integer, Integer> appendFreqMap = new HashMap<>();
        for (int i : _nums) {
            if (freqMap.get(i) != 0) {
                if (appendFreqMap.getOrDefault(i, 0) > 0) {
                    appendFreqMap.merge(i, -1, (o, n) -> o - 1);
                    appendFreqMap.merge(i + 1, 1, (o, n) -> o + 1);
                } else if (freqMap.getOrDefault(i + 1, 0) > 0 && freqMap.getOrDefault(i + 2, 0) > 0) {
                    freqMap.compute(i + 1, (k, o) -> o == null ? -1 : o - 1);
                    freqMap.merge(i + 2, -1, (o, n) -> o - 1);
                    appendFreqMap.merge(i + 3, 1, (o, n) -> o + 1);
                } else {
                    return false;
                }
                freqMap.merge(i, -1, (o, n) -> o - 1);
            }
        }
        return true;
    }

}
