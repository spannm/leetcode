package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 702. Search in a Sorted Array of Unknown Size.
 */
class Problem0702 extends LeetcodeProblem {

    int search(ArrayReader _reader, int _target) {
        int left = 0;
        int right = 20000;
        while (left < right) {
            int mid = left + right >> 1;
            if (_reader.get(mid) >= _target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return _reader.get(left) == _target ? left : -1;
    }

    abstract static class ArrayReader {
        abstract int get(int _mid);
    }

}
