package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0493 extends LeetcodeProblem {

    int reversePairs(int[] _nums) {
        return mergeSort(_nums, 0, _nums.length - 1);
    }

    static int mergeSort(int[] _nums, int _start, int _end) {
        if (_start >= _end) {
            return 0;
        }
        int mid = _start + (_end - _start) / 2;
        int cnt = mergeSort(_nums, _start, mid) + mergeSort(_nums, mid + 1, _end);
        for (int i = _start, j = mid + 1; i <= mid; i++) {
            while (j <= _end && _nums[i] > _nums[j] * 2.0) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        Arrays.sort(_nums, _start, _end + 1);
        return cnt;
    }

}
