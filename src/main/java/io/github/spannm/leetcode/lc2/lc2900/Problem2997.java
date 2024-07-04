package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2997. Minimum Number of Operations to Make Array XOR Equal to K.
 */
class Problem2997 extends LeetcodeProblem {

    int minOperations(int[] _nums, int _k) {
        for (int x : _nums) {
            _k ^= x;
        }
        return Integer.bitCount(_k);
    }

}
