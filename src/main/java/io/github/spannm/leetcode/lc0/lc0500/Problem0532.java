package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Problem0532 extends LeetcodeProblem {

    int findPairs(int[] _nums, int _k) {
        if (_nums == null || _nums.length == 0 || _k < 0) {
            return 0;
        }

        Map<Integer, Long> map = Arrays.stream(_nums).boxed().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        int answer = 0;
        for (int key : map.keySet()) {
            if (_k == 0) {
                if (map.get(key) >= 2) {
                    answer++;
                }
            } else if (map.containsKey(key + _k)) {
                answer++;
            }
        }
        return answer;
    }

}
