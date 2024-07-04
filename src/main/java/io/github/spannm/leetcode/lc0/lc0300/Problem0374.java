package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0374 extends LeetcodeProblem {

    int guessNumber(int _n) {
        int left = 1;
        int right = _n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int g = guess(mid);
            if (g == 0) {
                return mid;
            } else if (g > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return guess(left) == 0 ? left : right;
    }

    private int guess(int _num) {
        return Integer.compare(7, _num);
    }

}
