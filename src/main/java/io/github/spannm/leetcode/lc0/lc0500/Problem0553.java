package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0553 extends LeetcodeProblem {

    String optimalDivision(int[] _nums) {
        if (_nums.length == 1) {
            return "" + _nums[0];
        } else if (_nums.length == 2) {
            return _nums[0] + "/" + _nums[1];
        }

        java.util.StringJoiner stringJoiner = new java.util.StringJoiner("/");
        for (int i = 1; i < _nums.length; i++) {
            stringJoiner.add("" + _nums[i]);
        }
        return String.format("%d/(%s)", _nums[0], stringJoiner);
    }

}
