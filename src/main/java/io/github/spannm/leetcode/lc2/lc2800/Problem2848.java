package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.List;

/**
 * 2848. Points That Intersect With Cars.
 */
class Problem2848 extends LeetcodeProblem {

    int numberOfPoints(List<List<Integer>> nums) {
        int[] d = new int[110];
        for (var e : nums) {
            d[e.get(0)]++;
            d[e.get(1) + 1]--;
        }
        int ans = 0;
        int s = 0;
        for (int x : d) {
            s += x;
            if (s > 0) {
                ans++;
            }
        }
        return ans;
    }

}
