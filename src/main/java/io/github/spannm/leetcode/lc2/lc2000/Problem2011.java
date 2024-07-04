package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2011 extends LeetcodeProblem {

    int finalValueAfterOperations(String[] _operations) {
        int val = 0;
        for (String op : _operations) {
            if ("++X".equals(op) || "X++".equals(op)) {
                val++;
            } else {
                val--;
            }
        }
        return val;
    }

}
