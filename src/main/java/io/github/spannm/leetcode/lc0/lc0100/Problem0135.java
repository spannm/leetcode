package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/candy/">135. Candy</a>.
 */
class Problem0135 extends LeetcodeProblem {

    int candy(int[] _ratings) {
        final int len = _ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);

        for (int i = 0; i < len - 1; i++) {
            if (_ratings[i] < _ratings[i + 1]) {
                candies[i + 1] = candies[i] + 1;
            }
        }

        for (int i = len - 1; i > 0; i--) {
            if (_ratings[i] < _ratings[i - 1]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
        }

        return Arrays.stream(candies).sum();
    }

}
