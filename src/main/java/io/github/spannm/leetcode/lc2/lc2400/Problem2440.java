package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2440. Create Components With Same Value.
 */
class Problem2440 extends LeetcodeProblem {

    private List<Integer>[] g;
    private int[]           nums;
    private int             t;

    int componentValue(int[] _nums, int[][] _edges) {
        int n = _nums.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[n];
        g = lists;
        nums = _nums;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        int s = sum(_nums);
        int mx = max(_nums);
        for (int k = Math.min(n, s / mx); k > 1; k--) {
            if (s % k == 0) {
                t = s / k;
                if (dfs(0, -1) == 0) {
                    return k - 1;
                }
            }
        }
        return 0;
    }

    private int dfs(int _i, int _fa) {
        int x = nums[_i];
        for (int j : g[_i]) {
            if (j != _fa) {
                int y = dfs(j, _i);
                if (y == -1) {
                    return -1;
                }
                x += y;
            }
        }
        if (x > t) {
            return -1;
        }
        return x < t ? x : 0;
    }

    private int sum(int[] arr) {
        int x = 0;
        for (int v : arr) {
            x += v;
        }
        return x;
    }

    private int max(int[] arr) {
        int x = arr[0];
        for (int v : arr) {
            x = Math.max(x, v);
        }
        return x;
    }

}
