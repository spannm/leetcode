package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.TreeMap;

class Problem1296 extends LeetcodeProblem {

    boolean isPossibleDivide(int[] _nums, int _k) {
        if (_nums.length % _k != 0) {
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        int min = _nums[0];
        for (int num : _nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
        }
        while (!map.isEmpty()) {
            if (!isConsecutiveK(map, min, _k)) {
                return false;
            }
            min = findNextMin(map);
            if (min == Integer.MIN_VALUE) {
                break;
            }
        }
        return true;
    }

    static int findNextMin(Map<Integer, Integer> _map) {
        return _map.isEmpty() ? Integer.MIN_VALUE : _map.entrySet().iterator().next().getKey();
    }

    static boolean isConsecutiveK(Map<Integer, Integer> _map, int _min, int _k) {
        int count = _map.get(_min);
        _map.remove(_min);
        for (int i = 1; i < _k; i++) {
            int key = _min + i;
            if (!_map.containsKey(key) || _map.get(key) < count) {
                return false;
            } else if (_map.get(key) > count) {
                _map.put(key, _map.get(key) - count);
            } else {
                _map.remove(key);
            }
        }
        return true;
    }

}
