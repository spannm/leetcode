package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2670 extends LeetcodeProblem {

    int[] distinctDifferenceArray(int[] _nums) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(_nums[0], 1);
        Map<Integer, Integer> suffix = new HashMap<>();
        for (int i = 1; i < _nums.length; i++) {
            suffix.put(_nums[i], suffix.getOrDefault(_nums[i], 0) + 1);
        }
        int[] result = new int[_nums.length];
        for (int i = 0; i < _nums.length; i++) {
            result[i] = prefix.size() - suffix.size();
            if (i + 1 < _nums.length) {
                prefix.put(_nums[i + 1], prefix.getOrDefault(_nums[i + 1], 0) + 1);
                if (suffix.containsKey(_nums[i + 1]) && suffix.get(_nums[i + 1]) == 1) {
                    suffix.remove(_nums[i + 1]);
                } else {
                    suffix.put(_nums[i + 1], suffix.getOrDefault(_nums[i + 1], 0) - 1);
                }
            }
        }
        return result;
    }

}
