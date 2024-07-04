package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2838. Maximum Coins Heroes Can Collect.
 */
class Problem2838 extends LeetcodeProblem {

    long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int m = monsters.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, Comparator.comparingInt(j -> monsters[j]));
        long[] s = new long[m + 1];
        for (int i = 0; i < m; i++) {
            s[i + 1] = s[i] + coins[idx[i]];
        }
        int n = heroes.length;
        long[] ans = new long[n];
        for (int k = 0; k < n; k++) {
            int i = search(monsters, idx, heroes[k]);
            ans[k] = s[i];
        }
        return ans;
    }

    private int search(int[] nums, Integer[] idx, int x) {
        int l = 0;
        int r = idx.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[idx[mid]] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
