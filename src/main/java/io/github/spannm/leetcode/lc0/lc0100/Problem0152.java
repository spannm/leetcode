package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/maximum-product-subarray/">152. Maximum Product Subarray</a>.
 */
class Problem0152 extends LeetcodeProblem {

    int maxProduct(int[] _nums) {
        int pos = _nums[0];
        int neg = _nums[0];
        int max = _nums[0];
        for (int i = 1; i < _nums.length; i++) {
            int temp = pos;
            pos = Math.max(_nums[i], _nums[i] * (_nums[i] >= 0 ? pos : neg));
            neg = Math.min(_nums[i], _nums[i] * (_nums[i] >= 0 ? neg : temp));
            max = Math.max(max, pos);
        }
        return max;
    }

}
