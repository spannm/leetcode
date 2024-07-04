package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3068. Find the Maximum Sum of Node Values
 */
class Problem3068 extends LeetcodeProblem {

    long maximumValueSum(int[] _nums, int _k, int[][] _edges) {
        int len = _nums.length;

        if (len == 1) {
            return _nums[0];
        }

        int[] opts1 = new int[len];
        int[] opts2 = new int[len];

        for (int i = 0; i < len; i++) {
            opts1[i] = _nums[i];
            opts2[i] = _nums[i] ^ _k;
        }

        long bestOdd = opts2[0];
        long bestEven = opts1[0];

        for (int i = 1; i < len; i++) {
            long newOdd = Math.max(bestOdd + opts1[i], bestEven + opts2[i]);
            long newEven = Math.max(bestEven + opts1[i], bestOdd + opts2[i]);

            bestOdd = newOdd;
            bestEven = newEven;
        }

        return bestEven;
    }

}
