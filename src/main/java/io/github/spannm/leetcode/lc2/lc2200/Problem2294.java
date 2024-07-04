package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2294. Partition Array Such That Maximum Difference Is K.
 */
class Problem2294 extends LeetcodeProblem {

    int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 1;
        int a = nums[0];
        for (int b : nums) {
            if (b - a > k) {
                a = b;
                ans++;
            }
        }
        return ans;
    }

}
