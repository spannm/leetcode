package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2441. Largest Positive Integer That Exists With Its Negative.
 */
class Problem2441 extends LeetcodeProblem {

    int findMaxK(int[] nums) {
        Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int ans = -1;
        for (int x : s) {
            if (s.contains(-x)) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }

}
