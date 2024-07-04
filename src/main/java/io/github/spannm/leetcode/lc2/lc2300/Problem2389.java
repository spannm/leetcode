package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2389. Longest Subsequence With Limited Sum.
 */
class Problem2389 extends LeetcodeProblem {

    int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = search(nums, queries[i]);
        }
        return ans;
    }

    private int search(int[] nums, int x) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
