package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2588. Count the Number of Beautiful Subarrays.
 */
class Problem2588 extends LeetcodeProblem {

    long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        long ans = 0;
        int mask = 0;
        for (int x : nums) {
            mask ^= x;
            ans += cnt.getOrDefault(mask, 0);
            cnt.merge(mask, 1, Integer::sum);
        }
        return ans;
    }

}
