package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2894. Divisible and Non-divisible Sums Difference.
 */
class Problem2894 extends LeetcodeProblem {

    int differenceOfSums(int n, int m) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += i % m == 0 ? -i : i;
        }
        return ans;
    }

}
