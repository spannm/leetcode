package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 2971. Find Polygon With the Largest Perimeter.
 */
class Problem2971 extends LeetcodeProblem {

    long largestPerimeter(int[] _nums) {
        int len = _nums.length;
        long[] s = new long[len + 1];
        Arrays.sort(_nums);
        IntStream.rangeClosed(1, len).forEach(i -> s[i] = s[i - 1] + _nums[i - 1]);
        long result = -1;
        for (int k = 3; k <= len; k++) {
            if (s[k - 1] > _nums[k - 1]) {
                result = Math.max(result, s[k]);
            }
        }
        return result;
    }

}
