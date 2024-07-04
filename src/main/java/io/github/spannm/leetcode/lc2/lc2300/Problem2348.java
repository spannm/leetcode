package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/number-of-zero-filled-subarrays/">2348. Number of Zero-Filled Subarrays</a>.
 */
class Problem2348 extends LeetcodeProblem {

    long zeroFilledSubarray(int[] _nums) {
        final int len = _nums.length;
        if (len <= 1) {
            if (len == 1) {
                return _nums[0] == 0 ? 1 : 0;
            }
            return 0;
        }

        long total = 0;
        long zeroes = 0; // count of consecutive zeroes
        for (int i = 0; i < len; i++) {
            boolean isZero = _nums[i] == 0;
            if (isZero) {
                zeroes++;
            }
            if (!isZero || i == len - 1) {
                if (zeroes == 1) {
                    total++;
                } else {
                    total += java.util.stream.LongStream.rangeClosed(1, zeroes).sum();
                }
                zeroes = 0; // reset
            }
        }
        return total;
    }

}
