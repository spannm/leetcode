package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2966. Divide Array Into Arrays With Max Difference.
 */
class Problem2966 extends LeetcodeProblem {

    int[][] divideArray(int[] _nums, int _k) {
        Arrays.sort(_nums);
        int len = _nums.length;
        int[][] ans = new int[len / 3][];
        for (int i = 0; i < len; i += 3) {
            int[] t = Arrays.copyOfRange(_nums, i, i + 3);
            if (t[2] - t[0] > _k) {
                return new int[][] {};
            }
            ans[i / 3] = t;
        }
        return ans;
    }

}
