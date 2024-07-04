package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1769 extends LeetcodeProblem {

    int[] minOperations(String _boxes) {
        int[] box = new int[_boxes.length()];
        for (int i = 0; i < _boxes.length(); i++) {
            box[i] = _boxes.charAt(i) - '0';
        }
        int[] result = new int[_boxes.length()];
        for (int i = 0; i < _boxes.length(); i++) {
            int ops = 0;
            for (int j = 0; j < _boxes.length(); j++) {
                if (i != j && box[j] == 1) {
                    ops += Math.abs(j - i);
                }
            }
            result[i] = ops;
        }
        return result;
    }

}
