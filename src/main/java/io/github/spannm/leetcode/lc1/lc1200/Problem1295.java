package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1295 extends LeetcodeProblem {

    int findNumbers(int[] _nums) {
        int count = 0;
        for (int num : _nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

}
