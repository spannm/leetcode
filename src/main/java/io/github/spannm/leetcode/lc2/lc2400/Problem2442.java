package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2442. Count Number of Distinct Integers After Reverse Operations.
 */
class Problem2442 extends LeetcodeProblem {

    int countDistinctIntegers(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        for (int x : nums) {
            int y = 0;
            while (x > 0) {
                y = y * 10 + x % 10;
                x /= 10;
            }
            s.add(y);
        }
        return s.size();
    }

}
