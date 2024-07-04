package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0732 extends LeetcodeProblem {

    static class MyCalendarThree {
        private final SegmentTree tree = new SegmentTree();

        public int book(int start, int end) {
            tree.modify(start + 1, end, 1);
            return tree.query(1, (int) 1e9 + 1);
        }

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
            mid = l + r >> 1;
        }

    }

    static class SegmentTree {
        private final Node root = new Node(1, (int) 1e9 + 1);

        void modify(int l, int r, int v) {
            modify(l, r, v, root);
        }

        void modify(int l, int r, int v, Node node) {
            if (l > r) {
                return;
            } else if (node.l >= l && node.r <= r) {
                node.v += v;
                node.add += v;
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
                v = Math.max(v, query(l, r, node.left));
            }
            if (r > node.mid) {
                v = Math.max(v, query(l, r, node.right));
            }
            return v;
        }

        public void pushup(Node node) {
            node.v = Math.max(node.left.v, node.right.v);
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
                left.add += node.add;
                right.add += node.add;
                left.v += node.add;
                right.v += node.add;
                node.add = 0;
            }
        }

    }

}
