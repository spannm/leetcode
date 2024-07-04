package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2740. Find the Value of the Partition.
 */
class Problem2740 extends LeetcodeProblem {

    int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int ans = 1 << 30;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }

}
