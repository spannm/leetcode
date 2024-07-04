package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2302. Count Subarrays With Score Less Than K.
 */
class Problem2302 extends LeetcodeProblem {

    long countSubarrays(int[] nums, long k) {
        long ans = 0;
        long s = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            s += nums[i];
            while (s * (i - j + 1) >= k) {
                s -= nums[j++];
            }
            ans += i - j + 1;
        }
        return ans;
    }

}
