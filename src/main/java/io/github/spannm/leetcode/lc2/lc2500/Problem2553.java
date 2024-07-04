package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/separate-the-digits-in-an-array/"> 2553. Separate the Digits in an Array</a>.
 */
class Problem2553 extends LeetcodeProblem {

    int[] separateDigits(int[] _nums) {
        int n = 0;
        for (int num : _nums) {
            while (num > 0) {
                n++;
                num = num / 10;
            }
        }
        final int[] digits = new int[n];
        for (int i = _nums.length - 1; i >= 0; i--) {
            int currentNum = _nums[i];
            while (currentNum > 0) {
                digits[n - 1] = currentNum % 10;
                currentNum /= 10;
                n--;
            }
        }

        return digits;
    }

}
