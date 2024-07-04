package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2179. Count Good Triplets in an Array.
 */
class Problem2179 extends LeetcodeProblem {

    long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i + 1;
        }
        long ans = 0;
        for (int num : nums1) {
            int p = pos[num];
            long left = tree.query(p);
            long right = n - p - (tree.query(n) - tree.query(p));
            ans += left * right;
            tree.update(p, 1);
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

        void update(int x, int delta) {
            while (x <= n) {
                c[x] += delta;
                x += lowbit(x);
            }
        }

        int query(int x) {
            int s = 0;
            while (x > 0) {
                s += c[x];
                x -= lowbit(x);
            }
            return s;
        }

        static int lowbit(int x) {
            return x & -x;
        }

    }

}
