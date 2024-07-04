package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1681. Minimum Incompatibility.
 */
class Problem1681 extends LeetcodeProblem {

    int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        int m = n / k;
        int[] g = new int[1 << n];
        Arrays.fill(g, -1);
        for (int i = 1; i < 1 << n; i++) {
            if (Integer.bitCount(i) != m) {
                continue;
            }
            Set<Integer> s = new HashSet<>();
            int mi = 20;
            int mx = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    if (!s.add(nums[j])) {
                        break;
                    }
                    mi = Math.min(mi, nums[j]);
                    mx = Math.max(mx, nums[j]);
                }
            }
            if (s.size() == m) {
                g[i] = mx - mi;
            }
        }
        int[] f = new int[1 << n];
        final int inf = 1 << 30;
        Arrays.fill(f, inf);
        f[0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            if (f[i] == inf) {
                continue;
            }
            Set<Integer> s = new HashSet<>();
            int mask = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 0 && !s.contains(nums[j])) {
                    s.add(nums[j]);
                    mask |= 1 << j;
                }
            }
            if (s.size() < m) {
                continue;
            }
            for (int j = mask; j > 0; j = j - 1 & mask) {
                if (g[j] != -1) {
                    f[i | j] = Math.min(f[i | j], f[i] + g[j]);
                }
            }
        }
        return f[(1 << n) - 1] == inf ? -1 : f[(1 << n) - 1];
    }

}
