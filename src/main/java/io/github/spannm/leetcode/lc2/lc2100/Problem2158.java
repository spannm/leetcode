package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2158. Amount of New Area Painted Each Day.
 */
class Problem2158 extends LeetcodeProblem {

    int[] amountPainted(int[][] _paint) {
        SegmentTree tree = new SegmentTree();
        int n = _paint.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int l = _paint[i][0] + 1;
            int r = _paint[i][1];
            int v = tree.query(l, r);
            ans[i] = r - l + 1 - v;
            tree.modify(l, r, 1);
        }
        return ans;
    }

    static class Node {
        private Node      left;
        private Node      right;
        private final int l;
        private final int r;
        private final int mid;
        private int       v;
        private int       add;

        Node(int _l, int _r) {
            l = _l;
            r = _r;
            mid = _l + _r >> 1;
        }

    }

    static class SegmentTree {
        private final Node root = new Node(1, 100010);

        public void modify(int l, int r, int v) {
            modify(l, r, v, root);
        }

        public void modify(int l, int r, int v, Node node) {
            if (l > r) {
                return;
            }
            if (node.l >= l && node.r <= r) {
                node.v = node.r - node.l + 1;
                node.add = v;
                return;
            }
            pushdown(node);
            if (l <= node.mid) {
                modify(l, r, v, node.left);
            }
            if (r > node.mid) {
                modify(l, r, v, node.right);
            }
            pushup(node);
        }

        public int query(int l, int r) {
            return query(l, r, root);
        }

        public int query(int l, int r, Node node) {
            if (l > r) {
                return 0;
            }
            if (node.l >= l && node.r <= r) {
                return node.v;
            }
            pushdown(node);
            int v = 0;
            if (l <= node.mid) {
                v += query(l, r, node.left);
            }
            if (r > node.mid) {
                v += query(l, r, node.right);
            }
            return v;
        }

        public void pushup(Node node) {
            node.v = node.left.v + node.right.v;
        }

        public void pushdown(Node node) {
            if (node.left == null) {
                node.left = new Node(node.l, node.mid);
            }
            if (node.right == null) {
                node.right = new Node(node.mid + 1, node.r);
            }
            if (node.add != 0) {
                Node left = node.left;
                Node right = node.right;
                left.add = node.add;
                right.add = node.add;
                left.v = left.r - left.l + 1;
                right.v = right.r - right.l + 1;
                node.add = 0;
            }
        }

    }

}
