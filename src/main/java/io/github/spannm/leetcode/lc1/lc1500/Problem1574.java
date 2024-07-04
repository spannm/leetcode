package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1574 extends LeetcodeProblem {

    int findLengthOfShortestSubarray(int[] _arr) {
        int left = 0;
        while (left < _arr.length - 1 && _arr[left] <= _arr[left + 1]) {
            left++;
        }
        if (left == _arr.length - 1) {
            return 0;
        }
        int right = _arr.length - 1;
        while (right > left && _arr[right] >= _arr[right - 1]) {
            right--;
        }
        if (right == 0) {
            return _arr.length - 1;
        }
        int result = Math.min(_arr.length - left - 1, right);
        int i = 0;
        int j = right;
        while (i <= left && j < _arr.length) {
            if (_arr[j] >= _arr[i]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

}
