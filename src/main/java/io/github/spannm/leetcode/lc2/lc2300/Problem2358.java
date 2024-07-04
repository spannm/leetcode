package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2358. Maximum Number of Groups Entering a Competition.
 */
class Problem2358 extends LeetcodeProblem {

    int maximumGroups(int[] grades) {
        int n = grades.length;
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (1L * mid * mid + mid > n * 2L) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

}
