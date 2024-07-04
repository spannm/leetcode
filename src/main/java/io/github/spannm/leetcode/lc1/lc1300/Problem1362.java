package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1362 extends LeetcodeProblem {

    int[] closestDivisors(int _num) {
        int sqrt = (int) Math.sqrt(_num);
        int left = sqrt + 1;
        int right = sqrt + 1;
        long product = (long) left * right;
        while (product != _num + 1 && product != _num + 2) {
            if (product < _num + 1) {
                left++;
            } else if (product > _num + 2) {
                right--;
            }
            product = (long) left * right;
        }
        return new int[] {left, right};
    }

}
