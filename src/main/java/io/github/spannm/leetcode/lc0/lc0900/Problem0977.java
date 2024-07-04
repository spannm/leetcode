package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array/?envType=study-plan&id=algorithm-i">
 * 977. Squares of a Sorted Array</a>.
 */
class Problem0977 extends LeetcodeProblem {

    int[] sortedSquares(int[] _nums) {
        int len = _nums.length;
        int[] arr = new int[len];
        int fromBgn = 0;
        int fromEnd = len - 1;
        int k = len - 1;
        while (fromBgn <= fromEnd) {
            int val1 = _nums[fromBgn] * _nums[fromBgn];
            int val2 = _nums[fromEnd] * _nums[fromEnd];
            if (val1 > val2) {
                arr[k] = val1;
                fromBgn++;
            } else {
                arr[k] = val2;
                fromEnd--;
            }
            k--;
        }
        return arr;
    }

}
