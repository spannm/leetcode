package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0325 extends LeetcodeProblem {

    int maxSubArrayLen(int[] _nums, int _k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < _nums.length; i++) {
            sum += _nums[i];
            if (sum == _k) {
                max = i + 1;
            } else if (map.containsKey(sum - _k)) {
                max = Math.max(max, i - map.get(sum - _k));
            }
            map.putIfAbsent(sum, i);
        }
        return max;
    }

}
