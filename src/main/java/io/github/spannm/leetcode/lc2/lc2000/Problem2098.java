package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2098. Subsequence of Size K With the Largest Even Sum.
 */
class Problem2098 extends LeetcodeProblem {

    long largestEvenSum(int[] nums, int k) {
        Arrays.sort(nums);
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            ans += nums[n - i - 1];
        }
        if (ans % 2 == 0) {
            return ans;
        }
        final int inf = 1 << 29;
        int mx1 = -inf;
        int mx2 = -inf;
        for (int i = 0; i < n - k; i++) {
            if (nums[i] % 2 == 1) {
                mx1 = nums[i];
            } else {
                mx2 = nums[i];
            }
        }
        int mi1 = inf;
        int mi2 = inf;
        for (int i = n - 1; i >= n - k; i--) {
            if (nums[i] % 2 == 1) {
                mi2 = nums[i];
            } else {
                mi1 = nums[i];
            }
        }
        ans = Math.max(-1, Math.max(ans - mi1 + mx1, ans - mi2 + mx2));
        return ans % 2 != 0 ? -1 : ans;
    }

}
