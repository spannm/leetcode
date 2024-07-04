package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem0219 extends LeetcodeProblem {

    boolean containsNearbyDuplicate(int[] _nums, int _k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < _nums.length; i++) {
            if (map.containsKey(_nums[i])) {
                if (i - map.get(_nums[i]) <= _k) {
                    return true;
                }
            }
            map.put(_nums[i], i);
        }
        return false;
    }

}
