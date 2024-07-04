package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2407. Longest Increasing Subsequence II.
 */
class Problem2407 extends LeetcodeProblem {

    int lengthOfLIS(int[] nums, int k) {
        int mx = nums[0];
        for (int v : nums) {
            mx = Math.max(mx, v);
        }
        SegmentTree tree = new SegmentTree(mx);
        int ans = 0;
        for (int v : nums) {
            int t = tree.query(1, v - k, v - 1) + 1;
            ans = Math.max(ans, t);
            tree.modify(1, v, t);
        }
        return ans;
    }

    static class Node {
        private int l;
        private int r;
        private int v;
    }

    static class SegmentTree {
        private final Node[] tr;

        SegmentTree(int _n) {
            tr = new Node[4 * _n];
            for (int i = 0; i < tr.length; i++) {
                tr[i] = new Node();
            }
            build(1, 1, _n);
        }

        public void build(int u, int l, int r) {
            tr[u].l = l;
            tr[u].r = r;
            if (l == r) {
                return;
            }
            int mid = l + r >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
        }

        void modify(int u, int x, int v) {
            if (tr[u].l == x && tr[u].r == x) {
                tr[u].v = v;
                return;
            }
            int mid = tr[u].l + tr[u].r >> 1;
            if (x <= mid) {
                modify(u << 1, x, v);
            } else {
                modify(u << 1 | 1, x, v);
            }
            pushup(u);
        }

        void pushup(int u) {
            tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
        }

        int query(int u, int l, int r) {
            if (tr[u].l >= l && tr[u].r <= r) {
                return tr[u].v;
            }
            int mid = tr[u].l + tr[u].r >> 1;
            int v = 0;
            if (l <= mid) {
                v = query(u << 1, l, r);
            }
            if (r > mid) {
                v = Math.max(v, query(u << 1 | 1, l, r));
            }
            return v;
        }

    }

}
