package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1712. Ways to Split Array Into Three Subarrays.
 */
class Problem1712 extends LeetcodeProblem {

    private static final int MOD = (int) 1e9 + 7;

    int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] s = new int[n];
        s[0] = nums[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int j = search(s, s[i] << 1, i + 1, n - 1);
            int k = search(s, (s[n - 1] + s[i] >> 1) + 1, j, n - 1);
            ans = (ans + k - j) % MOD;
        }
        return ans;
    }

    private int search(int[] s, int x, int left, int right) {
        while (left < right) {
            int mid = left + right >> 1;
            if (s[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
