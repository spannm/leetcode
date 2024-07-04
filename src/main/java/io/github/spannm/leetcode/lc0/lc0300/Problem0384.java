package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Random;

/**
 * 384. Shuffle an Array.
 */
class Problem0384 extends LeetcodeProblem {

    static class Solution {

        private int[]        nums;
        private final int    len;
        private final int[]  original;
        private final Random rand;

        Solution(int[] _nums) {
            nums = _nums;
            len = _nums.length;
            original = Arrays.copyOf(_nums, len);
            rand = new Random();
        }

        int[] reset() {
            nums = Arrays.copyOf(original, len);
            return nums;
        }

        int[] shuffle() {
            for (int i = 0; i < len; i++) {
                swap(i, i + rand.nextInt(len - i));
            }
            return nums;
        }

        private void swap(int _i1, int _i2) {
            int t = nums[_i1];
            nums[_i1] = nums[_i2];
            nums[_i2] = t;
        }
    }

}
