package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/">1846. Maximum Element After
 * Decreasing and Rearranging</a>.
 */
class Problem1846 extends LeetcodeProblem {

    int maximumElementAfterDecrementingAndRearranging(int[] _arr) {
        boolean flag = false;
        int len = _arr.length;
        if (len == 1) {
            return 1;
        }

        for (int i = 0; i < len - 1; i++) {
            if (_arr[i] > _arr[i + 1] || _arr[i + 1] - _arr[i] > 1 || _arr[0] != 1) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            return _arr[len - 1];
        }

        Arrays.sort(_arr);

        for (int i = 0; i < len; i++) {
            if (i == 0 && _arr[0] != 1) {
                _arr[0] = 1;
            } else if (i > 0) {
                if (_arr[i] - _arr[i - 1] > 1) {
                    _arr[i] = _arr[i - 1] + 1;
                }
            }
        }

        int result = _arr[len - 1];

        _arr = null;
        System.gc();

        return result;
    }

}
