package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2453. Destroy Sequential Targets.
 */
class Problem2453 extends LeetcodeProblem {

    int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            v %= space;
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        int ans = 0;
        int mx = 0;
        for (int v : nums) {
            int t = cnt.get(v % space);
            if (t > mx || t == mx && v < ans) {
                ans = v;
                mx = t;
            }
        }
        return ans;
    }

}
