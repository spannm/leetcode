package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2364. Count Number of Bad Pairs.
 */
class Problem2364 extends LeetcodeProblem {

    long countBadPairs(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = i - nums[i];
            ans += i - cnt.getOrDefault(x, 0);
            cnt.merge(x, 1, Integer::sum);
        }
        return ans;
    }

}
