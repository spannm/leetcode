package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0698 extends LeetcodeProblem {

    boolean canPartitionKSubsets(int[] _nums, int _k) {
        long sum = 0;
        for (int num : _nums) {
            sum += num;
        }
        if (sum % _k != 0) {
            return false;
        }
        int equalSum = (int) (sum / _k);
        boolean[] visited = new boolean[_nums.length];
        return canPartition(_nums, visited, 0, _k, 0, 0, equalSum);
    }

    private boolean canPartition(int[] _nums, boolean[] _visited, int _startIndex, int _k, int _currSum, int _currNum, int _target) {
        if (_k == 1) {
            return true;
        } else if (_currSum == _target && _currNum > 0) {
            return canPartition(_nums, _visited, 0, _k - 1, 0, 0, _target);
        }
        for (int i = _startIndex; i < _nums.length; i++) {
            if (!_visited[i]) {
                _visited[i] = true;
                if (canPartition(_nums, _visited, i + 1, _k, _currSum + _nums[i], _currNum++, _target)) {
                    return true;
                }
                _visited[i] = false;
            }
        }
        return false;
    }

}
