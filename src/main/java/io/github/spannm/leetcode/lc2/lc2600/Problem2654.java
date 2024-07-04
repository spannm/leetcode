package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2654. Minimum Number of Operations to Make All Array Elements Equal to 1.
 */
class Problem2654 extends LeetcodeProblem {

    int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int x : nums) {
            if (x == 1) {
                cnt++;
            }
        }
        if (cnt > 0) {
            return n - cnt;
        }
        int mi = n + 1;
        for (int i = 0; i < n; i++) {
            int g = 0;
            for (int j = i; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    mi = Math.min(mi, j - i + 1);
                }
            }
        }
        return mi > n ? -1 : n - 1 + mi - 1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
