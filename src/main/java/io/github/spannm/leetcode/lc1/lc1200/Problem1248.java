package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1248. Count Number of Nice Subarrays.
 */
class Problem1248 extends LeetcodeProblem {

    int numberOfSubarrays(int[] _nums, int _k) {
        int len = _nums.length;
        int[] count = new int[len + 1];
        count[0] = 1;
        int result = 0;
        int t = 0;
        for (int n : _nums) {
            t += n & 1;
            if (t - _k >= 0) {
                result += count[t - _k];
            }
            count[t]++;
        }
        return result;
    }

}
