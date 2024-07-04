package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2834. Find the Minimum Possible Sum of a Beautiful Array.
 */
class Problem2834 extends LeetcodeProblem {

    long minimumPossibleSum(int n, int target) {
        boolean[] vis = new boolean[n + target];
        long ans = 0;
        for (int i = 1; n > 0; n--, i++) {
            while (vis[i]) {
                i++;
            }
            ans += i;
            if (target >= i) {
                vis[target - i] = true;
            }
        }
        return ans;
    }

}
