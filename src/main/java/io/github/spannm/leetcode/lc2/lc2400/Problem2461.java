package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2461. Maximum Sum of Distinct Subarrays With Length K.
 */
class Problem2461 extends LeetcodeProblem {

    long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>(k);
        long s = 0;
        for (int i = 0; i < k; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
            s += nums[i];
        }
        long ans = cnt.size() == k ? s : 0;
        for (int i = k; i < n; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
            s += nums[i];
            if (cnt.merge(nums[i - k], -1, Integer::sum) == 0) {
                cnt.remove(nums[i - k]);
            }
            s -= nums[i - k];
            if (cnt.size() == k) {
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }

}
