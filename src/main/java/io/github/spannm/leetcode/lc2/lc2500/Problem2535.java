package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2535 extends LeetcodeProblem {

    int differenceOfSum(int[] _nums) {
        long elementSum = 0L;
        long digitSum = 0L;
        for (int num : _nums) {
            elementSum += num;
            while (num != 0) {
                digitSum += num % 10;
                num /= 10;
            }
        }
        return (int) Math.abs(elementSum - digitSum);
    }

}
