package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem1483 extends LeetcodeProblem {

    static class TreeAncestor {
        private final int[][] p;

        TreeAncestor(int n, int[] parent) {
            p = new int[n][18];
            for (var e : p) {
                Arrays.fill(e, -1);
            }
            for (int i = 0; i < n; i++) {
                p[i][0] = parent[i];
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < 18; j++) {
                    if (p[i][j - 1] == -1) {
                        continue;
                    }
                    p[i][j] = p[p[i][j - 1]][j - 1];
                }
            }
        }

        int getKthAncestor(int node, int k) {
            for (int i = 17; i >= 0; i--) {
                if ((k >> i & 1) == 1) {
                    node = p[node][i];
                    if (node == -1) {
                        break;
                    }
                }
            }
            return node;
        }

    }

}
