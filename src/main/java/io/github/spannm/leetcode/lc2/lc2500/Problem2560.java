package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2560. House Robber IV.
 */
class Problem2560 extends LeetcodeProblem {

    int minCapability(int[] nums, int k) {
        int left = 0;
        int right = (int) 1e9;
        while (left < right) {
            int mid = left + right >> 1;
            if (f(nums, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] nums, int x) {
        int cnt = 0;
        int j = -2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > x || i == j + 1) {
                continue;
            }
            cnt++;
            j = i;
        }
        return cnt;
    }

}
