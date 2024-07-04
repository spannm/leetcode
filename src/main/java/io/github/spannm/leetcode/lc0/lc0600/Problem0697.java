package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Problem0697 extends LeetcodeProblem {

    int findShortestSubArray(int[] _nums) {
        Map<Integer, Long> counts = Arrays.stream(_nums).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        long degree = counts.values().stream().mapToLong(l -> l).max().getAsLong();
        List<Integer> candidateNums = new ArrayList<>();
        for (int key : counts.keySet()) {
            if (counts.get(key) == degree) {
                candidateNums.add(key);
            }
        }
        int shortest = Integer.MAX_VALUE;
        for (int candidate : candidateNums) {
            shortest = Math.min(shortest, findLength(_nums, candidate));
        }
        return shortest;
    }

    static int findLength(int[] _arr, int _candidate) {
        int firstAppearance = Integer.MAX_VALUE;
        for (int i = 0; i < _arr.length; i++) {
            if (_arr[i] == _candidate) {
                firstAppearance = i;
                break;
            }
        }
        int lastAppearance = _arr.length - 1;
        for (int i = _arr.length - 1; i > firstAppearance; i--) {
            if (_arr[i] == _candidate) {
                lastAppearance = i;
                break;
            }
        }
        return lastAppearance - firstAppearance + 1;
    }

}
