package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1679 extends LeetcodeProblem {

    int maxOperations(int[] _nums, int _k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ops = 0;
        for (int num : _nums) {
            if (map.containsKey(_k - num)) {
                map.put(_k - num, map.get(_k - num) - 1);
                ops++;
                if (map.get(_k - num) == 0) {
                    map.remove(_k - num);
                }
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return ops;
    }

}
