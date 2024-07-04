package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1894. Find the Student that Will Replace the Chalk.
 */
class Problem1894 extends LeetcodeProblem {

    int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] s = new long[n + 1];
        s[0] = chalk[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + chalk[i];
        }
        k %= s[n - 1];
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (s[mid] > k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
