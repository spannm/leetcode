package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1460 extends LeetcodeProblem {

    boolean canBeEqual(int[] _target, int[] _arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : _target) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : _arr) {
            if (!map.containsKey(num)) {
                return false;
            } else {
                map.put(num, map.get(num) - 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

}
