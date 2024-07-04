package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0421 extends LeetcodeProblem {

    int findMaximumXOR(int[] _nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            Set<Integer> set = new HashSet<>();
            for (int num : _nums) {
                set.add(num & mask);
            }

            int candidate = max | 1 << i;
            for (int prefix : set) {
                if (set.contains(candidate ^ prefix)) {
                    max = candidate;
                    break;
                }
            }
        }
        return max;
    }

}
