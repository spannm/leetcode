package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/">1491. Average Salary
 * Excluding the Minimum and Maximum Salary</a>.
 */
class Problem1491 extends LeetcodeProblem {

    double average(final int[] _salaries) {
        final int len = _salaries.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        int sum = 0;
        for (int salary : _salaries) {
            min = Math.min(min, salary);
            max = Math.max(max, salary);
            sum += salary;
        }
        return (double) (sum - min - max) / (len - 2);
    }

}
