package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2496 extends LeetcodeProblem {

    int maximumValue(String[] _strs) {
        int max = 0;
        for (String str : _strs) {
            try {
                int num = Integer.parseInt(str);
                max = Math.max(max, num);
            } catch (Exception _ex) {
                max = Math.max(max, str.length());
            }
        }
        return max;
    }

}
