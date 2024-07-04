package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2376. Count Special Integers.
 */
class Problem2376 extends LeetcodeProblem {

    int countSpecialNumbers(int _n) {
        List<Integer> digits = new ArrayList<>();
        while (_n != 0) {
            digits.add(_n % 10);
            _n /= 10;
        }
        int m = digits.size();
        int ans = 0;
        for (int i = 1; i < m; i++) {
            ans += 9 * f(9, i - 1);
        }
        boolean[] vis = new boolean[10];
        for (int i = m - 1; i >= 0; i--) {
            int v = digits.get(i);
            for (int j = i == m - 1 ? 1 : 0; j < v; j++) {
                if (vis[j]) {
                    continue;
                }
                ans += f(10 - (m - i), i);
            }
            if (vis[v]) {
                break;
            }
            vis[v] = true;
            if (i == 0) {
                ans++;
            }
        }
        return ans;
    }

    private int f(int _m, int _n) {
        return _n == 0 ? 1 : f(_m, _n - 1) * (_m - _n + 1);
    }

}
