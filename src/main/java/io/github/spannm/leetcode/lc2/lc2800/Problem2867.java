package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2867. Count Valid Paths in a Tree.
 */
class Problem2867 extends LeetcodeProblem {

    long countPaths(int n, int[][] edges) {
        List<Boolean> prime = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            prime.add(true);
        }
        prime.set(1, false);

        List<Integer> all = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime.get(i)) {
                all.add(i);
            }
            for (int x : all) {
                int temp = i * x;
                if (temp > n) {
                    break;
                }
                prime.set(temp, false);
                if (i % x == 0) {
                    break;
                }
            }
        }

        List<List<Integer>> con = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            con.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            con.get(e[0]).add(e[1]);
            con.get(e[1]).add(e[0]);
        }

        long[] r = {0};
        dfs(1, 0, con, prime, r);
        return r[0];
    }

    private long mul(long x, long y) {
        return x * y;
    }

    static class Pair {
        private int first;
        private int second;

        Pair(int _first, int _second) {
            first = _first;
            second = _second;
        }
    }

    private Pair dfs(int x, int f, List<List<Integer>> con, List<Boolean> prime, long[] r) {
        Pair v = new Pair(!prime.get(x) ? 1 : 0, prime.get(x) ? 1 : 0);
        for (int y : con.get(x)) {
            if (y == f) {
                continue;
            }
            Pair p = dfs(y, x, con, prime, r);
            r[0] += mul(p.first, v.second) + mul(p.second, v.first);
            if (prime.get(x)) {
                v.second += p.first;
            } else {
                v.first += p.first;
                v.second += p.second;
            }
        }
        return v;
    }

}
