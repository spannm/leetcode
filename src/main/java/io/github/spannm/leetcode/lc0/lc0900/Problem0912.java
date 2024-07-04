package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/sort-an-array/">912. Sort an Array</a>.
 */
class Problem0912 extends LeetcodeProblem {

    int[] sortArray(int[] _nums) {
        return sortArrayMemoryInefficient(_nums);
    }

    static void mergeSort(int[] _arr, int _len) {
        if (_len < 2) {
            return;
        }
        final int mid = _len / 2;
        final int[] left = new int[mid];
        final int[] right = new int[_len - mid];

        System.arraycopy(_arr, 0, left, 0, mid);
        if (_len - mid >= 0) {
            System.arraycopy(_arr, mid, right, 0, _len - mid);
        }
        mergeSort(left, mid);
        mergeSort(right, _len - mid);

        merge(_arr, left, right, mid, _len - mid);
    }

    static void merge(int[] _arr, int[] _left, int[] _right, int _lenLeft, int _lenRight) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < _lenLeft && j < _lenRight) {
            if (_left[i] <= _right[j]) {
                _arr[k++] = _left[i++];
            } else {
                _arr[k++] = _right[j++];
            }
        }
        while (i < _lenLeft) {
            _arr[k++] = _left[i++];
        }
        while (j < _lenRight) {
            _arr[k++] = _right[j++];
        }
    }

    int[] sortArrayMemoryInefficient(int[] _nums) {
        int max = _nums[0];
        int min = _nums[0];
        for (int num : _nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int diff = max - min;
        int[] arr = new int[diff + 1];
        for (int num : _nums) {
            arr[num - min]++;
        }
        int index = 0;
        for (int i = 0; i <= diff; i++) {
            while (arr[i] > 0) {
                _nums[index] = min;
                index++;
                arr[i]--;
            }
            min++;
        }
        return _nums;
    }

}
