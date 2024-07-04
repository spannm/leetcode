package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2184. Number of Ways to Build Sturdy Brick Wall.
 */
class Problem2184 extends LeetcodeProblem {

    private static final int          MOD = (int) 1e9 + 7;

    private int                       width;
    private int[]                     bricks;
    private final List<List<Integer>> res = new ArrayList<>();
    private final List<Integer>       t   = new ArrayList<>();

    int buildWall(int _height, int _width, int[] _bricks) {
        width = _width;
        bricks = _bricks;
        dfs(0);
        int n = res.size();
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (check(res.get(i), res.get(i))) {
                g[i].add(i);
            }
            for (int j = i + 1; j < n; j++) {
                if (check(res.get(i), res.get(j))) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }
        int[][] dp = new int[_height][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < _height; i++) {
            for (int j = 0; j < n; j++) {
                for (int k : g[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            ans = (ans + dp[_height - 1][j]) % MOD;
        }
        return ans;
    }

    private boolean check(List<Integer> _a, List<Integer> _b) {
        int s1 = _a.get(0);
        int s2 = _b.get(0);
        int i = 1;
        int j = 1;
        while (i < _a.size() && j < _b.size()) {
            if (s1 == s2) {
                return false;
            }
            if (s1 < s2) {
                s1 += _a.get(i++);
            } else {
                s2 += _b.get(j++);
            }
        }
        return true;
    }

    private void dfs(int _v) {
        if (_v > width) {
            return;
        }
        if (_v == width) {
            res.add(new ArrayList<>(t));
            return;
        }
        for (int x : bricks) {
            t.add(x);
            dfs(_v + x);
            t.remove(t.size() - 1);
        }
    }

}
