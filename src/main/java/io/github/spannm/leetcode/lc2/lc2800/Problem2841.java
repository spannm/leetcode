package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2841. Maximum Sum of Almost Unique Subarray.
 */
class Problem2841 extends LeetcodeProblem {

    long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = nums.size();
        long s = 0;
        for (int i = 0; i < k; i++) {
            cnt.merge(nums.get(i), 1, Integer::sum);
            s += nums.get(i);
        }
        long ans = 0;
        if (cnt.size() >= m) {
            ans = s;
        }
        for (int i = k; i < n; i++) {
            cnt.merge(nums.get(i), 1, Integer::sum);
            if (cnt.merge(nums.get(i - k), -1, Integer::sum) == 0) {
                cnt.remove(nums.get(i - k));
            }
            s += nums.get(i) - nums.get(i - k);
            if (cnt.size() >= m) {
                ans = Math.max(ans, s);
            }
        }
        return ans;
    }

}
