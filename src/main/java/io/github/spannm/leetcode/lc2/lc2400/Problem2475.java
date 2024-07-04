package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2475. Number of Unequal Triplets in Array.
 */
class Problem2475 extends LeetcodeProblem {

    int unequalTriplets(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            cnt.merge(v, 1, Integer::sum);
        }
        int ans = 0;
        int a = 0;
        int n = nums.length;
        for (int b : cnt.values()) {
            int c = n - a - b;
            ans += a * b * c;
            a += b;
        }
        return ans;
    }

}
