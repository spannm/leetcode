package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2113. Elements in Array After Removing and Replacing Elements.
 */
class Problem2113 extends LeetcodeProblem {

    int[] elementInNums(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        for (int j = 0; j < m; j++) {
            ans[j] = -1;
            int t = queries[j][0];
            int i = queries[j][1];
            t %= 2 * n;
            if (t < n && i < n - t) {
                ans[j] = nums[i + t];
            } else if (t > n && i < t - n) {
                ans[j] = nums[i];
            }
        }
        return ans;
    }

}
