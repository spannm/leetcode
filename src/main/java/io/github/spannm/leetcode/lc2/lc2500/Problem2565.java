package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2565. Subsequence With the Minimum Score.
 */
class Problem2565 extends LeetcodeProblem {

    private int   m;
    private int   n;
    private int[] f;
    private int[] g;

    int minimumScore(String s, String t) {
        m = s.length();
        n = t.length();
        f = new int[n];
        g = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1 << 30;
            g[i] = -1;
        }
        for (int i = 0, j = 0; i < m && j < n; i++) {
            if (s.charAt(i) == t.charAt(j)) {
                f[j] = i;
                j++;
            }
        }
        for (int i = m - 1, j = n - 1; i >= 0 && j >= 0; i--) {
            if (s.charAt(i) == t.charAt(j)) {
                g[j] = i;
                j--;
            }
        }
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int len) {
        for (int k = 0; k < n; k++) {
            int i = k - 1;
            int j = k + len;
            int l = i >= 0 ? f[i] : -1;
            int r = j < n ? g[j] : m + 1;
            if (l < r) {
                return true;
            }
        }
        return false;
    }

}
