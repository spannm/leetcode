package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2829. Determine the Minimum Sum of a k-avoiding Array.
 */
class Problem2829 extends LeetcodeProblem {

    int minimumSum(int n, int k) {
        int s = 0;
        int i = 1;
        boolean[] vis = new boolean[k + n * n + 1];
        while (n-- > 0) {
            while (vis[i]) {
                i++;
            }
            vis[i] = true;
            if (k >= i) {
                vis[k - i] = true;
            }
            s += i;
        }
        return s;
    }

}
