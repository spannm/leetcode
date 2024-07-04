package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeSet;

class Problem0821 extends LeetcodeProblem {

    int[] shortestToChar(String _s, char _c) {
        int[] result = new int[_s.length()];
        TreeSet<Integer> cIndices = new TreeSet<>();
        for (int i = 0; i < _s.length(); i++) {
            if (_s.charAt(i) == _c) {
                cIndices.add(i);
            }
        }
        for (int i = 0; i < _s.length(); i++) {
            int leftDist = Integer.MAX_VALUE;
            if (cIndices.floor(i) != null) {
                leftDist = Math.abs(cIndices.floor(i) - i);
            }
            int rightDist = Integer.MAX_VALUE;
            if (cIndices.ceiling(i) != null) {
                rightDist = Math.abs(cIndices.ceiling(i) - i);
            }
            result[i] = Math.min(leftDist, rightDist);
        }
        return result;
    }

}
