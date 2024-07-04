package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0525 extends LeetcodeProblem {

    int findMaxLength(int[] _nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(count, -1);
        int max = 0;
        for (int i = 0; i < _nums.length; i++) {
            count += _nums[i] == 1 ? 1 : -1;
            Integer val = map.putIfAbsent(count, i);
            if (val != null) {
                max = Math.max(i - val, max);
            }
        }
        return max;
    }

}
