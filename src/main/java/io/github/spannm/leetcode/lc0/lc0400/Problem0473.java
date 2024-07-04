package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0473 extends LeetcodeProblem {

    boolean makesquare(int[] _nums) {
        if (_nums == null || _nums.length < 4) {
            return false;
        }
        Arrays.sort(_nums);
        reverse(_nums);
        int sum = Arrays.stream(_nums).sum();
        return sum % 4 == 0 && dfs(_nums, new int[4], 0, sum / 4);
    }

    static boolean dfs(int[] _nums, int[] _sums, int _index, int _target) {
        if (_index == _nums.length) {
            return _sums[0] == _target && _sums[1] == _target && _sums[2] == _target;
        }
        for (int i = 0; i < 4; i++) {
            if (_sums[i] + _nums[_index] > _target) {
                continue;
            }
            _sums[i] += _nums[_index];
            if (dfs(_nums, _sums, _index + 1, _target)) {
                return true;
            }
            _sums[i] -= _nums[_index];
        }
        return false;
    }

    static void reverse(int[] _nums) {
        int left = 0;
        int right = _nums.length - 1;
        while (left < right) {
            int tmp = _nums[left];
            _nums[left] = _nums[right];
            _nums[right] = tmp;
            left++;
            right--;
        }
    }

}
