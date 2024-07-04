package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Random;

class Problem0528 extends LeetcodeProblem {
    static class Solution {

        private final Random random;
        private final int[]  preSums;

        Solution(int[] _w) {
            random = new Random();
            for (int i = 1; i < _w.length; i++) {
                _w[i] += _w[i - 1];
            }
            preSums = _w;
        }

        public int pickIndex() {
            int len = preSums.length;
            int idx = random.nextInt(preSums[len - 1]) + 1;
            int left = 0;
            int right = len - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (preSums[mid] == idx) {
                    return mid;
                } else if (preSums[mid] < idx) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }

}
