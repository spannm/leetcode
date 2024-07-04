package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Problem2126 extends LeetcodeProblem {

    boolean asteroidsDestroyed(int _mass, int[] _asteroids) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : _asteroids) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int[] nums = new int[map.keySet().size()];
        int i = 0;
        for (int key : map.keySet()) {
            nums[i++] = key;
        }
        Arrays.sort(nums);
        int startIndex = 0;
        long sum = _mass;
        int upToIndex = binarySearch(sum, nums, startIndex, nums.length - 1);
        while (upToIndex < nums.length) {
            for (i = startIndex; i <= upToIndex; i++) {
                sum += (long) map.get(nums[i]) * nums[i];
            }
            if (upToIndex == nums.length - 1) {
                return true;
            }
            startIndex = upToIndex + 1;
            upToIndex = binarySearch(sum, nums, startIndex, nums.length - 1);
            if (startIndex > upToIndex) {
                return false;
            }
        }
        return true;
    }

    private int binarySearch(long _sum, int[] _nums, int _left, int _right) {
        while (_left < _right) {
            int mid = _left + (_right - _left) / 2;
            if (_nums[mid] < _sum) {
                _left = mid + 1;
            } else if (_nums[mid] > _sum) {
                _right = mid - 1;
            } else {
                return mid;
            }
        }
        return _right < _nums.length && _nums[_right] <= _sum ? _right : _left - 1;
    }

}
