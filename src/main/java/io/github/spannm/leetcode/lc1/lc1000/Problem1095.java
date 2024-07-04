package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/find-in-mountain-array/">1095. Find in Mountain Array</a>.
 */
class Problem1095 extends LeetcodeProblem {

    int findInMountainArray(int _target, MountainArray _mountainArr) {
        int len = _mountainArr.length();
        int peakIndex = findPeakIndex(_mountainArr, len);

        int result = findTargetIndex(_mountainArr, 0, peakIndex, _target, true);
        return result > -1 ? result : findTargetIndex(_mountainArr, peakIndex + 1, len - 1, _target, false);
    }

    static int findTargetIndex(MountainArray _arr, int _leftIdx, int _rightIdx, int _target, boolean _isUpside) {
        while (_leftIdx <= _rightIdx) {
            int midIdx = _leftIdx + (_rightIdx - _leftIdx) / 2;
            int midVal = _arr.get(midIdx);

            if (midVal == _target) {
                return midIdx;
            } else if (_isUpside) {
                if (midVal < _target) {
                    _leftIdx = midIdx + 1;
                } else {
                    _rightIdx = midIdx - 1;
                }
            } else {
                if (midVal < _target) {
                    _rightIdx = midIdx - 1;
                } else {
                    _leftIdx = midIdx + 1;
                }
            }
        }

        return -1;
    }

    static int findPeakIndex(MountainArray _arr, int _length) {
        int left = 0;
        int right = _length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (_arr.get(mid) < _arr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    @SuppressWarnings({"PMD.ClassNamingConventions", "checkstyle:TypeNameCheck"})
    interface MountainArray {
        int get(int _index);

        int length();
    }

}
