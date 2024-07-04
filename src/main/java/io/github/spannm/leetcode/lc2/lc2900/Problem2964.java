package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2964. Number of Divisible Triplet Sums.
 */
class Problem2964 extends LeetcodeProblem {

    int divisibleTripletCount(int[] nums, int d) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int x = (d - (nums[j] + nums[k]) % d) % d;
                ans += cnt.getOrDefault(x, 0);
            }
            cnt.merge(nums[j] % d, 1, Integer::sum);
        }
        return ans;
    }

}
