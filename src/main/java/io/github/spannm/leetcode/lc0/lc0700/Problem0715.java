package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0715 extends LeetcodeProblem {

    static class RangeModule {
        private final SegmentTree tree = new SegmentTree();

        public void addRange(int left, int right) {
            tree.modify(left, right - 1, 1);
        }

        public boolean queryRange(int left, int right) {
            return tree.query(left, right - 1);
        }

        public void removeRange(int left, int right) {
            tree.modify(left, right - 1, -1);
        }

    }

    static class Node {
        private Node    left;
        private Node    right;
        private int     add;
        private boolean v;
    }

    static class SegmentTree {
        private final Node root = new Node();

        public void modify(int _left, int _right, int _v) {
            modify(_left, _right, _v, 1, (int) 1e9, root);
        }

        public void modify(int _left, int _right, int _v, int _l, int _r, Node _node) {
            if (_l >= _left && _r <= _right) {
                _node.v = _v == 1;
                _node.add = _v;
                return;
            }
            pushdown(_node);
            int mid = _l + _r >> 1;
            if (_left <= mid) {
                modify(_left, _right, _v, _l, mid, _node.left);
            }
            if (_right > mid) {
                modify(_left, _right, _v, mid + 1, _r, _node.right);
            }
            pushup(_node);
        }

        public boolean query(int _left, int _right) {
            return query(_left, _right, 1, (int) 1e9, root);
        }

        public boolean query(int _left, int _right, int _l, int _r, Node _node) {
            if (_l >= _left && _r <= _right) {
                return _node.v;
            }
            pushdown(_node);
            int mid = _l + _r >> 1;
            boolean v = true;
            if (_left <= mid) {
                v = query(_left, _right, _l, mid, _node.left);
            }
            if (_right > mid) {
                v = v && query(_left, _right, mid + 1, _r, _node.right);
            }
            return v;
        }

        public void pushup(Node node) {
            node.v = node.left != null && node.left.v && node.right != null && node.right.v;
        }

        public void pushdown(Node node) {
            if (node.left == null) {
                node.left = new Node();
            }
            if (node.right == null) {
                node.right = new Node();
            }
            if (node.add != 0) {
                node.left.add = node.add;
                node.right.add = node.add;
                node.left.v = node.add == 1;
                node.right.v = node.add == 1;
                node.add = 0;
            }
        }

    }

}
