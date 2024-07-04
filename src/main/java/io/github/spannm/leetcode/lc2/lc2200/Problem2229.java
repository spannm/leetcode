package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeSet;

class Problem2229 extends LeetcodeProblem {

    boolean isConsecutive(int[] _nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int min = _nums[0];
        int max = _nums[0];
        for (int num : _nums) {
            treeSet.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return treeSet.size() == max - min + 1 && treeSet.size() == _nums.length;
    }

}
