package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2078 extends LeetcodeProblem {

    int maxDistance(int[] _colors) {
        int left = 0;
        int right = _colors.length - 1;
        int max = 0;
        while (left < right) {
            if (_colors[left] != _colors[right]) {
                max = Math.max(max, right - left);
                break;
            } else {
                left++;
            }
        }
        left = 0;
        while (left < right) {
            if (_colors[left] != _colors[right]) {
                max = Math.max(max, right - left);
                break;
            } else {
                right--;
            }
        }
        return max;
    }

}
