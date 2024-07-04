package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 798. Smallest Rotation with Highest Score.
 */
class Problem0798 extends LeetcodeProblem {

    int bestRotation(int[] _nums) {
        int n = _nums.length;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            int l = (i + 1) % n;
            int r = (n + i + 1 - _nums[i]) % n;
            d[l]++;
            d[r]--;
        }
        int mx = -1;
        int s = 0;
        int ans = n;
        for (int k = 0; k < n; k++) {
            s += d[k];
            if (s > mx) {
                mx = s;
                ans = k;
            }
        }
        return ans;
    }

}
