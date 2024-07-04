package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2537. Count the Number of Good Subarrays.
 */
class Problem2537 extends LeetcodeProblem {

    long countGood(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;
        long cur = 0;
        int i = 0;
        for (int x : nums) {
            cur += cnt.getOrDefault(x, 0);
            cnt.merge(x, 1, Integer::sum);
            while (cur - cnt.get(nums[i]) + 1 >= k) {
                cur -= cnt.merge(nums[i++], -1, Integer::sum);
            }
            if (cur >= k) {
                ans += i + 1;
            }
        }
        return ans;
    }

}
