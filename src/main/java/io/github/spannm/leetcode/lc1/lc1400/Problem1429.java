package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

class Problem1429 extends LeetcodeProblem {

    static class FirstUnique {

        private final Set<Integer> uniqSet;
        private final Set<Integer> nonUniqSet;

        FirstUnique(int[] _nums) {
            uniqSet = new LinkedHashSet<>();
            nonUniqSet = new HashSet<>();
            for (int num : _nums) {
                add(num);
            }
        }

        int showFirstUnique() {
            if (!uniqSet.isEmpty()) {
                return uniqSet.iterator().next();
            }
            return -1;
        }

        void add(int _value) {
            if (uniqSet.contains(_value)) {
                uniqSet.remove(_value);
                nonUniqSet.add(_value);
            }
            if (!nonUniqSet.contains(_value)) {
                uniqSet.add(_value);
            }
        }
    }

}
