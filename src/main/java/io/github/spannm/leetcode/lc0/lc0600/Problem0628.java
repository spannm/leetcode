package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0628 extends LeetcodeProblem {

    int maximumProduct(int[] _nums) {
        int len = _nums.length;
        Arrays.sort(_nums);
        int product = 1;
        if (len >= 3) {
            for (int i = len - 1; i >= len - 3; i--) {
                product *= _nums[i];
            }
            int another = _nums[0] * _nums[1] * _nums[len - 1];
            return Math.max(product, another);
        }
        return Arrays.stream(_nums).reduce(1, (a, b) -> a * b);
    }

}
