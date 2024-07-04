package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2501. Longest Square Streak in an Array.
 */
class Problem2501 extends LeetcodeProblem {

    int longestSquareStreak(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int v : nums) {
            s.add(v);
        }
        int ans = -1;
        for (int v : nums) {
            int t = 0;
            while (s.contains(v)) {
                v *= v;
                t++;
            }
            if (t > 1) {
                ans = Math.max(ans, t);
            }
        }
        return ans;
    }

}
