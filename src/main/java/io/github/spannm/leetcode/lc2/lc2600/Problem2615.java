package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2615. Sum of Distances.
 */
class Problem2615 extends LeetcodeProblem {

    long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> d = new HashMap<>();
        for (int i = 0; i < n; i++) {
            d.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (var idx : d.values()) {
            int m = idx.size();
            long left = 0;
            long right = -1L * m * idx.get(0);
            for (int i : idx) {
                right += i;
            }
            for (int i = 0; i < m; i++) {
                ans[idx.get(i)] = left + right;
                if (i + 1 < m) {
                    left += (idx.get(i + 1) - idx.get(i)) * (i + 1L);
                    right -= (idx.get(i + 1) - idx.get(i)) * (m - i - 1L);
                }
            }
        }
        return ans;
    }

}
