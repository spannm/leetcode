package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0414 extends LeetcodeProblem {

    int thirdMax(int[] _nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = max1;
        long max3 = max2;
        for (int i : _nums) {
            max1 = Math.max(max1, i);
        }
        for (int i : _nums) {
            if (i != max1) {
                max2 = Math.max(max2, i);
            }
        }
        for (int i : _nums) {
            if (i != max1 && i != max2) {
                max3 = Math.max(max3, i);
            }
        }
        return (int) (max3 == Long.MIN_VALUE ? max1 : max3);
    }

}
