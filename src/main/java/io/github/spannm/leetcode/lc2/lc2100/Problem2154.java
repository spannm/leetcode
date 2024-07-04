package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem2154 extends LeetcodeProblem {

    int findFinalValue(int[] _nums, int _original) {
        Set<Integer> set = new HashSet<>();
        for (int num : _nums) {
            set.add(num);
        }
        while (set.contains(_original)) {
            _original *= 2;
        }
        return _original;
    }

}
