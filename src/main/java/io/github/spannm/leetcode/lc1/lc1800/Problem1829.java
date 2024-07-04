package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1829 extends LeetcodeProblem {

    int[] getMaximumXor(int[] _nums, int _maximumBit) {
        int[] result = new int[_nums.length];
        long[] xOr = new long[_nums.length];
        xOr[0] = _nums[0];
        for (int i = 1; i < _nums.length; i++) {
            xOr[i] ^= xOr[i - 1] ^ _nums[i];
        }
        long maxNum = (long) Math.pow(2, _maximumBit) - 1;
        for (int i = 0; i < _nums.length; i++) {
            result[_nums.length - i - 1] = (int) (maxNum ^ xOr[i]);
        }
        return result;
    }

}
