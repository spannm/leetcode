package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1689 extends LeetcodeProblem {

    int minPartitions(String _n) {
        int max = 0;
        for (char c : _n.toCharArray()) {
            int num = Integer.parseInt(c + "");
            max = Math.max(max, num);
        }
        return max;
    }

}
