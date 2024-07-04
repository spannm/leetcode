package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 1044. Longest Duplicate Substring.
 */
class Problem1044 extends LeetcodeProblem {

    private long[] p;
    private long[] h;

    String longestDupSubstring(String _s) {
        int base = 131;
        int n = _s.length();
        p = new long[n + 10];
        h = new long[n + 10];
        p[0] = 1;
        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] * base;
            h[i + 1] = h[i] * base + _s.charAt(i);
        }
        String ans = "";
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            String t = check(_s, mid);
            if (!t.isEmpty()) {
                left = mid;
                ans = t;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private String check(String _s, int _len) {
        int n = _s.length();
        Set<Long> vis = new HashSet<>();
        for (int i = 1; i + _len - 1 <= n; i++) {
            int j = i + _len - 1;
            long t = h[j] - h[i - 1] * p[j - i + 1];
            if (vis.contains(t)) {
                return _s.substring(i - 1, j);
            }
            vis.add(t);
        }
        return "";
    }

}
