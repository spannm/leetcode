package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2343. Query Kth Smallest Trimmed Number.
 */
class Problem2343 extends LeetcodeProblem {

    int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        String[][] t = new String[n][2];
        for (int i = 0; i < m; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            for (int j = 0; j < n; j++) {
                t[j] = new String[] {nums[j].substring(nums[j].length() - trim), String.valueOf(j)};
            }
            Arrays.sort(t, Comparator.comparing((String[] a) -> a[0]).thenComparingInt(a -> Integer.parseInt(a[1])));
            ans[i] = Integer.parseInt(t[k - 1][1]);
        }
        return ans;
    }

}
