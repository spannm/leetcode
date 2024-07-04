package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2568. Minimum Impossible OR.
 */
class Problem2568 extends LeetcodeProblem {

    int minImpossibleOR(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        for (int i = 0;; i++) {
            if (!s.contains(1 << i)) {
                return 1 << i;
            }
        }
    }

}
