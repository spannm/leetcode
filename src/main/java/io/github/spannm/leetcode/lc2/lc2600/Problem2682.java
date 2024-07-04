package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2682. Find the Losers of the Circular Game.
 */
class Problem2682 extends LeetcodeProblem {

    int[] circularGameLosers(int n, int k) {
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for (int i = 0, p = 1; !vis[i]; p++) {
            vis[i] = true;
            cnt++;
            i = (i + p * k) % n;
        }
        int[] ans = new int[n - cnt];
        for (int i = 0, j = 0; i < n; i++) {
            if (!vis[i]) {
                ans[j++] = i + 1;
            }
        }
        return ans;
    }

}
