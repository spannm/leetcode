package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1168. Optimize Water Distribution in a Village.
 */
class Problem1168 extends LeetcodeProblem {

    int minCostToSupplyWater(int _n, int[] _wells, int[][] _pipes) {
        int[][] nums = Arrays.copyOf(_pipes, _pipes.length + _n);
        for (int i = 0; i < _n; i++) {
            nums[_pipes.length + i] = new int[] {0, i + 1, _wells[i]};
        }
        Arrays.sort(nums, Comparator.comparingInt(a -> a[2]));
        UnionFind uf = new UnionFind(_n + 1);
        int ans = 0;
        for (var x : nums) {
            int a = x[0];
            int b = x[1];
            int c = x[2];
            if (uf.union(a, b)) {
                ans += c;
                if (--_n == 0) {
                    break;
                }
            }
        }
        return ans;
    }

    static class UnionFind {
        private final int[] p;
        private final int[] size;

        UnionFind(int _n) {
            p = new int[_n];
            size = new int[_n];
            for (int i = 0; i < _n; i++) {
                p[i] = i;
                size[i] = 1;
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
            if (size[pa] > size[pb]) {
                p[pb] = pa;
                size[pa] += size[pb];
            } else {
                p[pa] = pb;
                size[pb] += size[pa];
            }
            return true;
        }

    }

}
