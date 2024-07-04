package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2798. Number of Employees Who Met the Target.
 */
class Problem2798 extends LeetcodeProblem {

    int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int x : hours) {
            if (x >= target) {
                ans++;
            }
        }
        return ans;
    }

}
