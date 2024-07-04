package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0696 extends LeetcodeProblem {

    int countBinarySubstrings(String _s) {
        int len = _s.length();
        int[][] a = new int[len][2];
        int[][] b = new int[len][2];
        for (int i = 0; i < len; i++) {
            if (_s.charAt(i) == '0') {
                a[i][0] = 1 + (i - 1 >= 0 ? a[i - 1][0] : 0);
            } else {
                a[i][1] = 1 + (i - 1 >= 0 ? a[i - 1][1] : 0);
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (_s.charAt(i) == '0') {
                b[i][0] = 1 + (i + 1 < len ? b[i + 1][0] : 0);
            } else {
                b[i][1] = 1 + (i + 1 < len ? b[i + 1][1] : 0);
            }

        }
        long ans = 0;
        for (int i = 0; i + 1 < len; i++) {
            ans += Math.min(a[i][0], b[i + 1][1]);
            ans += Math.min(a[i][1], b[i + 1][0]);
        }
        return (int) ans;
    }

}
