package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1785 extends LeetcodeProblem {

    int minElements(int[] _nums, int _limit, int _goal) {
        long sum = 0;
        for (int num : _nums) {
            sum += num;
        }
        long diff = Math.abs(_goal - sum);
        return diff % _limit == 0 ? (int) (diff / _limit) : (int) (diff / _limit + 1);
    }

}
