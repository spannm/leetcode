package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 2709. Greatest Common Divisor Traversal.
 */
class Problem2709 extends LeetcodeProblem {

    boolean canTraverseAllPairs(int[] _nums) {
        int max = 1 + Arrays.stream(_nums).max().getAsInt();
        @SuppressWarnings("unchecked")
        List<Integer>[] lst  = new List[max];
        Arrays.setAll(lst, x -> new ArrayList<>());
        int v;
        int i;
        for (int x = 1; x < max; x++) {
            v = x;
            i = 2;
            while (i <= v / i) {
                if (v % i == 0) {
                    lst[x].add(i);
                    while (v % i == 0) {
                        v /= i;
                    }
                }
                i++;
            }
            if (v > 1) {
                lst[x].add(v);
            }
        }

        int m = max - 1;
        int n = _nums.length;
        UnionFind uf = new UnionFind(n + m + 1);
        for (i = 0; i < n; i++) {
            for (int j : lst[_nums[i]]) {
                uf.union(i, j + n);
            }
        }
        return IntStream.range(0, n).map(uf::find).distinct().count() == 1;
    }

    static class UnionFind {
        private final int[] p;
        private final int[] sz;

        UnionFind(int _n) {
            p = new int[_n];
            sz = new int[_n];
            for (int i = 0; i < _n; i++) {
                p[i] = i;
                sz[i] = 1;
            }
        }

        int find(int _x) {
            if (p[_x] != _x) {
                p[_x] = find(p[_x]);
            }
            return p[_x];
        }

        boolean union(int _a, int _b) {
            int pa = find(_a);
            int pb = find(_b);
            if (pa == pb) {
                return false;
            }
            if (sz[pa] > sz[pb]) {
                p[pb] = pa;
                sz[pa] += sz[pb];
            } else {
                p[pa] = pb;
                sz[pb] += sz[pa];
            }
            return true;
        }

    }

}
