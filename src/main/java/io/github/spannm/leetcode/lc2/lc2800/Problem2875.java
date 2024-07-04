package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2875. Minimum Size Subarray in Infinite Array.
 */
class Problem2875 extends LeetcodeProblem {

    int minSizeSubarray(int[] nums, int target) {
        long s = Arrays.stream(nums).sum();
        int n = nums.length;
        int a = 0;
        if (target > s) {
            a = n * (target / (int) s);
            target -= target / s * s;
        }
        if (target == s) {
            return n;
        }
        Map<Long, Integer> pos = new HashMap<>();
        pos.put(0L, -1);
        long pre = 0;
        int b = 1 << 30;
        for (int i = 0; i < n; i++) {
            pre += nums[i];
            if (pos.containsKey(pre - target)) {
                b = Math.min(b, i - pos.get(pre - target));
            }
            if (pos.containsKey(pre - (s - target))) {
                b = Math.min(b, n - (i - pos.get(pre - (s - target))));
            }
            pos.put(pre, i);
        }
        return b == 1 << 30 ? -1 : a + b;
    }

}
