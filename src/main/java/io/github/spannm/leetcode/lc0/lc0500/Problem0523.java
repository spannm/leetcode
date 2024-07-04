package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0523 extends LeetcodeProblem {

    boolean checkSubarraySum(int[] _nums, int _k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < _nums.length; i++) {
            sum += _nums[i];
            if (_k != 0) {
                sum %= _k;
            }
            Integer prev = map.putIfAbsent(sum, i);
            if (prev != null && i - prev > 1) {
                return true;
            }
        }
        return false;
    }

}
