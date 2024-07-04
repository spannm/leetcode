package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2672. Number of Adjacent Elements With the Same Color.
 */
class Problem2672 extends LeetcodeProblem {

    int[] colorTheArray(int n, int[][] queries) {
        int m = queries.length;
        int[] nums = new int[n];
        int[] ans = new int[m];
        for (int k = 0, x = 0; k < m; k++) {
            int i = queries[k][0];
            int c = queries[k][1];
            if (i > 0 && nums[i] > 0 && nums[i - 1] == nums[i]) {
                x--;
            }
            if (i < n - 1 && nums[i] > 0 && nums[i + 1] == nums[i]) {
                x--;
            }
            if (i > 0 && nums[i - 1] == c) {
                x++;
            }
            if (i < n - 1 && nums[i + 1] == c) {
                x++;
            }
            ans[k] = x;
            nums[i] = c;
        }
        return ans;
    }

}
