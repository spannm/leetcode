package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * 2863. Maximum Length of Semi-Decreasing Subarrays.
 */
class Problem2863 extends LeetcodeProblem {

    int maxSubarrayLength(int[] nums) {
        TreeMap<Integer, List<Integer>> d = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            d.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        int k = 1 << 30;
        for (List<Integer> idx : d.values()) {
            ans = Math.max(ans, idx.get(idx.size() - 1) - k + 1);
            k = Math.min(k, idx.get(0));
        }
        return ans;
    }

}
