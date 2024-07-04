package io.github.spannm.leetcode.lc1.lc1900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 1931. Painting a Grid With Three Different Colors.
 */
class Problem1931 extends LeetcodeProblem {

    private int m;

    int colorTheGrid(int _x, int _y) {
        m = _x;
        final int mod = (int) 1e9 + 7;
        int mx = (int) Math.pow(3, _x);
        Set<Integer> valid = new HashSet<>();
        int[] f = new int[mx];
        for (int i = 0; i < mx; i++) {
            if (f1(i)) {
                valid.add(i);
                f[i] = 1;
            }
        }
        Map<Integer, List<Integer>> d = new HashMap<>();
        for (int i : valid) {
            for (int j : valid) {
                if (f2(i, j)) {
                    d.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        for (int k = 1; k < _y; k++) {
            int[] g = new int[mx];
            for (int i : valid) {
                for (int j : d.getOrDefault(i, List.of())) {
                    g[i] = (g[i] + f[j]) % mod;
                }
            }
            f = g;
        }
        int ans = 0;
        for (int x : f) {
            ans = (ans + x) % mod;
        }
        return ans;
    }

    boolean f1(int x) {
        int last = -1;
        for (int i = 0; i < m; i++) {
            if (x % 3 == last) {
                return false;
            }
            last = x % 3;
            x /= 3;
        }
        return true;
    }

    boolean f2(int x, int y) {
        for (int i = 0; i < m; i++) {
            if (x % 3 == y % 3) {
                return false;
            }
            x /= 3;
            y /= 3;
        }
        return true;
    }

}
