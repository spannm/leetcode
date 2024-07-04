package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2470. Number of Subarrays With LCM Equal to K.
 */
class Problem2470 extends LeetcodeProblem {

    int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            for (int j = i; j < n; j++) {
                int b = nums[j];
                int x = lcm(a, b);
                if (x == k) {
                    ans++;
                }
                a = x;
            }
        }
        return ans;
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
