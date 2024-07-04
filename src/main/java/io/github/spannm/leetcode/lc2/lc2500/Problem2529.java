package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2529 extends LeetcodeProblem {

    int maximumCount(int[] _nums) {
        int pos = 0;
        int neg = 0;
        for (int num : _nums) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }
        return Math.max(pos, neg);
    }

}
