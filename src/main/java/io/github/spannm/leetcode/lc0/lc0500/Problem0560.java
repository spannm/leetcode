package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0560 extends LeetcodeProblem {

    int subarraySum(int[] _nums, int _k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        int sum = 0;
        int result = 0;
        preSum.put(0, 1);
        for (int num : _nums) {
            sum += num;
            result += preSum.getOrDefault(sum - _k, 0);
            preSum.compute(sum, (k, v) -> (v == null ? 0 : v) + 1);
        }
        return result;
    }

}
