package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1562. Find Latest Group of Size M.
 */
class Problem1562 extends LeetcodeProblem {

    int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) {
            return n;
        }
        int[] cnt = new int[n + 2];
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int v = arr[i];
            int l = cnt[v - 1];
            int r = cnt[v + 1];
            if (l == m || r == m) {
                ans = i;
            }
            cnt[v - l] = l + r + 1;
            cnt[v + r] = l + r + 1;
        }
        return ans;
    }

}
