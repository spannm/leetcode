package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0633 extends LeetcodeProblem {

    boolean judgeSquareSum(int _c) {
        long left = 0;
        long right = (long) Math.sqrt(_c);
        while (left <= right) {
            long curr = left * left + right * right;
            if (curr > _c) {
                right--;
            } else if (curr < _c) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }

}
