package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2143. Choose Numbers From Two Arrays in Range.
 */
class Problem2143 extends LeetcodeProblem {

    int countSubranges(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int s1 = Arrays.stream(nums1).sum();
        int s2 = Arrays.stream(nums2).sum();
        int[][] f = new int[n][s1 + s2 + 1];
        int ans = 0;
        final int mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int b = nums2[i];
            f[i][a + s2]++;
            f[i][-b + s2]++;
            if (i > 0) {
                for (int j = 0; j <= s1 + s2; j++) {
                    if (j >= a) {
                        f[i][j] = (f[i][j] + f[i - 1][j - a]) % mod;
                    }
                    if (j + b <= s1 + s2) {
                        f[i][j] = (f[i][j] + f[i - 1][j + b]) % mod;
                    }
                }
            }
            ans = (ans + f[i][s2]) % mod;
        }
        return ans;
    }

}
