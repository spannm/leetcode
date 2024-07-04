package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2831. Find the Longest Equal Subarray.
 */
class Problem2831 extends LeetcodeProblem {

    int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int mx = 0;
        int l = 0;
        for (int r = 0; r < nums.size(); r++) {
            cnt.merge(nums.get(r), 1, Integer::sum);
            mx = Math.max(mx, cnt.get(nums.get(r)));
            if (r - l + 1 - mx > k) {
                cnt.merge(nums.get(l++), -1, Integer::sum);
            }
        }
        return mx;
    }

}
