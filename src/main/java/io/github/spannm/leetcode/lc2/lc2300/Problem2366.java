package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/minimum-replacements-to-sort-the-array/">2366. Minimum Replacements to Sort
 * the Array</a>.
 */
class Problem2366 extends LeetcodeProblem {

    long minimumReplacement(int[] _nums) {
        final int len = _nums.length;
        long res = 0;
        int x = 0;
        int a = 0;
        int b = 0;
        for (int i = len - 1; i >= 1; i--) {
            a = _nums[i];
            b = _nums[i - 1];
            if (a < b) {
                x = (b - 1) / a;
                res += x;
                if (b % a == 0) {
                    _nums[i - 1] = a;
                } else {
                    _nums[i - 1] = b / (x + 1);
                }
            }
        }
        return res;
    }

}
