package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0275 extends LeetcodeProblem {

    int hIndex(int[] _citations) {
        int left = 0;
        int len = _citations.length;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (_citations[mid] >= len - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }

}
