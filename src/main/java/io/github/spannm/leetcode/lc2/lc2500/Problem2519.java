package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2519. Count the Number of K-Big Indices.
 */
class Problem2519 extends LeetcodeProblem {

    int kBigIndices(int[] nums, int k) {
        int n = nums.length;
        BinaryIndexedTree tree1 = new BinaryIndexedTree(n);
        BinaryIndexedTree tree2 = new BinaryIndexedTree(n);
        for (int v : nums) {
            tree2.update(v, 1);
        }
        int ans = 0;
        for (int v : nums) {
            tree2.update(v, -1);
            if (tree1.query(v - 1) >= k && tree2.query(v - 1) >= k) {
                ans++;
            }
            tree1.update(v, 1);
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

        void update(int _x, int _delta) {
            while (_x <= n) {
                c[_x] += _delta;
                _x += _x & -_x;
            }
        }

        int query(int _x) {
            int s = 0;
            while (_x > 0) {
                s += c[_x];
                _x -= _x & -_x;
            }
            return s;
        }

    }

}
