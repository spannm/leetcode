package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1918. Kth Smallest Subarray Sum.
 */
class Problem1918 extends LeetcodeProblem {

    int kthSmallestSubarraySum(int[] nums, int k) {
        int l = 1 << 30;
        int r = 0;
        for (int x : nums) {
            l = Math.min(l, x);
            r += x;
        }
        while (l < r) {
            int mid = l + r >> 1;
            if (f(nums, mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int f(int[] nums, int s) {
        int t = 0;
        int j = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            t += nums[i];
            while (t > s) {
                t -= nums[j++];
            }
            cnt += i - j + 1;
        }
        return cnt;
    }

}
