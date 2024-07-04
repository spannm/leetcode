package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2819. Minimum Relative Loss After Buying Chocolates.
 */
class Problem2819 extends LeetcodeProblem {

    private int[] prices;
    private int   len;

    long[] minimumRelativeLosses(int[] _prices, int[][] _queries) {
        prices = _prices;
        len = _prices.length;
        Arrays.sort(_prices);
        long[] s = new long[len + 1];
        for (int i = 0; i < len; i++) {
            s[i + 1] = s[i] + _prices[i];
        }
        int q = _queries.length;
        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            int k = _queries[i][0];
            int m = _queries[i][1];
            int l = f(k, m);
            int r = m - l;
            ans[i] = s[l] + 2L * k * r - (s[len] - s[len - r]);
        }
        return ans;
    }

    private int f(int k, int m) {
        int l = 0;
        int r = Arrays.binarySearch(prices, k);
        if (r < 0) {
            r = -(r + 1);
        }
        r = Math.min(m, r);
        while (l < r) {
            int mid = l + r >> 1;
            int right = m - mid;
            if (prices[mid] < 2L * k - prices[len - right]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

}
