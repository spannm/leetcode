package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2910. Minimum Number of Groups to Create a Valid Assignment.
 */
class Problem2910 extends LeetcodeProblem {

    int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int k = nums.length;
        for (int v : cnt.values()) {
            k = Math.min(k, v);
        }
        for (;; k--) {
            int ans = 0;
            for (int v : cnt.values()) {
                if (v / k < v % k) {
                    ans = 0;
                    break;
                }
                ans += (v + k) / (k + 1);
            }
            if (ans > 0) {
                return ans;
            }
        }
    }

}
