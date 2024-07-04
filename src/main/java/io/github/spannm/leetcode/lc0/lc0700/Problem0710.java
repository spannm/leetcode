package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 710. Random Pick with Blacklist.
 */
class Problem0710 extends LeetcodeProblem {

    static class Solution {
        private final Map<Integer, Integer> d    = new HashMap<>();
        private final Random                rand = new Random();
        private final int                   k;

        Solution(int _n, int[] _blacklist) {
            k = _n - _blacklist.length;
            int i = k;
            Set<Integer> black = new HashSet<>();
            for (int b : _blacklist) {
                black.add(b);
            }
            for (int b : _blacklist) {
                if (b < k) {
                    while (black.contains(i)) {
                        i++;
                    }
                    d.put(b, i++);
                }
            }
        }

        int pick() {
            int x = rand.nextInt(k);
            return d.getOrDefault(x, x);
        }
    }

}
