package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2962. Count Subarrays Where Max Element Appears at Least K Times.
 */
class Problem2962 extends LeetcodeProblem {

    long countSubarrays(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;
        long ans = 0;
        int cnt = 0;
        int j = 0;
        for (int x : nums) {
            while (j < n && cnt < k) {
                cnt += nums[j++] == mx ? 1 : 0;
            }
            if (cnt < k) {
                break;
            }
            ans += n - j + 1;
            cnt -= x == mx ? 1 : 0;
        }
        return ans;
    }

}
