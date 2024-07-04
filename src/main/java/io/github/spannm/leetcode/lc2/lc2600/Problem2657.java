package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2657. Find the Prefix Common Array of Two Arrays.
 */
class Problem2657 extends LeetcodeProblem {

    int[] findThePrefixCommonArray(int[] _a, int[] _b) {
        int n = _a.length;
        int[] ans = new int[n];
        int[] vis = new int[n + 1];
        Arrays.fill(vis, 1);
        int s = 0;
        for (int i = 0; i < n; i++) {
            vis[_a[i]] ^= 1;
            s += vis[_a[i]];
            vis[_b[i]] ^= 1;
            s += vis[_b[i]];
            ans[i] = s;
        }
        return ans;
    }

}
