package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1464 extends LeetcodeProblem {

    int maxProduct(int[] _nums) {
        int max1 = 1;
        int max2 = 0;

        for (int num : _nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }

}
