package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2576. Find the Maximum Number of Marked Indices.
 */
class Problem2576 extends LeetcodeProblem {

    int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0, j = (n + 1) / 2; j < n; i++, j++) {
            while (j < n && nums[i] * 2 > nums[j]) {
                j++;
            }
            if (j < n) {
                ans += 2;
            }
        }
        return ans;
    }

}
