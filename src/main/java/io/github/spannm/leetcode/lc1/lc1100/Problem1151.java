package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1151 extends LeetcodeProblem {

    int minSwaps(int[] _data) {
        int oneCount = 0;
        for (int d : _data) {
            if (d == 1) {
                oneCount++;
            }
        }
        if (oneCount <= 1) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int ones = 0;
        int zeroes = 0;
        int minSwaps = _data.length;
        while (right < _data.length) {
            if (_data[right] == 1) {
                ones++;
            } else {
                zeroes++;
            }
            if (ones + zeroes == oneCount) {
                minSwaps = Math.min(minSwaps, zeroes);
                if (_data[left] == 1) {
                    ones--;
                } else {
                    zeroes--;
                }
                left++;
            }
            right++;
        }
        return minSwaps;
    }

}
