package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1198 extends LeetcodeProblem {

    int smallestCommonElement(int[][] _mat) {
        int m = _mat.length;
        int n = _mat[0].length;
        for (int j = 0; j < n; j++) {
            int minCommon = _mat[0][j];

            int i = 1;
            for (; i < m; i++) {
                if (thisRowHasThisNumber(_mat[i], minCommon)) {
                    continue;
                } else {
                    break;
                }
            }
            if (i == m) {
                return minCommon;
            }
        }
        return -1;
    }

    private boolean thisRowHasThisNumber(int[] _nums, int _target) {
        int left = 0;
        int right = _nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (_target == _nums[mid]) {
                return true;
            } else if (_target > _nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
