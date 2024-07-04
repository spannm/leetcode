package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 1054. Distant Barcodes.
 */
class Problem1054 extends LeetcodeProblem {

    int[] rearrangeBarcodes(int[] _barcodes) {
        int n = _barcodes.length;
        Integer[] t = new Integer[n];
        int mx = 0;
        for (int i = 0; i < n; i++) {
            t[i] = _barcodes[i];
            mx = Math.max(mx, _barcodes[i]);
        }
        int[] cnt = new int[mx + 1];
        for (int x : _barcodes) {
            cnt[x]++;
        }
        Arrays.sort(t, (a, b) -> cnt[a] == cnt[b] ? a - b : cnt[b] - cnt[a]);
        int[] ans = new int[n];
        for (int k = 0, j = 0; k < 2; k++) {
            for (int i = k; i < n; i += 2) {
                ans[i] = t[j++];
            }
        }
        return ans;
    }

}
