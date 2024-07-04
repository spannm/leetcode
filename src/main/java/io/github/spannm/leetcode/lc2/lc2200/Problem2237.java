package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2237. Count Positions on Street With Required Brightness.
 */
class Problem2237 extends LeetcodeProblem {

    int meetRequirement(int n, int[][] lights, int[] requirement) {
        int[] d = new int[100010];
        for (int[] e : lights) {
            int i = Math.max(0, e[0] - e[1]);
            int j = Math.min(n - 1, e[0] + e[1]);
            d[i]++;
            --d[j + 1];
        }
        int s = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            s += d[i];
            if (s >= requirement[i]) {
                ans++;
            }
        }
        return ans;
    }

}
