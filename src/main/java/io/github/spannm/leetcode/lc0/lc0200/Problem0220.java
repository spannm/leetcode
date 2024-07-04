package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeSet;

class Problem0220 extends LeetcodeProblem {

    boolean containsNearbyAlmostDuplicate(int[] _nums, int _k, int _t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < _nums.length; i++) {
            Long s = set.ceiling((long) _nums[i]);
            if (s != null && s - _nums[i] <= _t) {
                return true;
            }

            Long g = set.floor((long) _nums[i]);
            if (g != null && _nums[i] - g <= _t) {
                return true;
            }

            set.add((long) _nums[i]);
            if (set.size() > _k) {
                set.remove((long) _nums[i - _k]);
            }
        }
        return false;
    }

}
