package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1649. Create Sorted Array through Instructions.
 */
class Problem1649 extends LeetcodeProblem {

    int createSortedArray(int[] instructions) {
        int m = 0;
        for (int x : instructions) {
            m = Math.max(m, x);
        }
        BinaryIndexedTree tree = new BinaryIndexedTree(m);
        int ans = 0;
        final int mod = (int) 1e9 + 7;
        for (int i = 0; i < instructions.length; i++) {
            int x = instructions[i];
            int cost = Math.min(tree.query(x - 1), i - tree.query(x));
            ans = (ans + cost) % mod;
            tree.update(x, 1);
        }
        return ans;
    }

    static class BinaryIndexedTree {
        private final int   n;
        private final int[] c;

        BinaryIndexedTree(int _n) {
            n = _n;
            c = new int[_n + 1];
        }

        void update(int x, int v) {
            while (x <= n) {
                c[x] += v;
                x += x & -x;
            }
        }

        int query(int x) {
            int s = 0;
            while (x > 0) {
                s += c[x];
                x -= x & -x;
            }
            return s;
        }

    }

}
