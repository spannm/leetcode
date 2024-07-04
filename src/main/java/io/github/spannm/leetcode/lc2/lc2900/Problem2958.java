package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2958. Length of Longest Subarray With at Most K Frequency.
 */
class Problem2958 extends LeetcodeProblem {

    int maxSubarrayLength(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>(len);
        int ans = 0;
        for (int i = 0, j = 0; i < len; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
            while (cnt.get(nums[i]) > k) {
                cnt.merge(nums[j++], -1, Integer::sum);
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

}
