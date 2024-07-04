package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2276 extends LeetcodeProblem {

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
        private final Node root = new Node(1, (int) 1e9 + 1);

        void modify(int _l, int _r, int _v) {
            modify(_l, _r, _v, root);
        }

        void modify(int _l, int _r, int _v, Node _node) {
            if (_l > _r) {
                return;
            }
            if (_node.l >= _l && _node.r <= _r) {
                _node.v = _node.r - _node.l + 1;
                _node.add = _v;
                return;
            }
            pushdown(_node);
            if (_l <= _node.mid) {
                modify(_l, _r, _v, _node.left);
            }
            if (_r > _node.mid) {
                modify(_l, _r, _v, _node.right);
            }
            pushup(_node);
        }

        int query(int l, int r) {
            return query(l, r, root);
        }

        int query(int _l, int _r, Node _node) {
            if (_l > _r) {
                return 0;
            } else if (_node.l >= _l && _node.r <= _r) {
                return _node.v;
            }
            pushdown(_node);
            int v = 0;
            if (_l <= _node.mid) {
                v += query(_l, _r, _node.left);
            }
            if (_r > _node.mid) {
                v += query(_l, _r, _node.right);
            }
            return v;
        }

        void pushup(Node _node) {
            _node.v = _node.left.v + _node.right.v;
        }

        void pushdown(Node _node) {
            if (_node.left == null) {
                _node.left = new Node(_node.l, _node.mid);
            }
            if (_node.right == null) {
                _node.right = new Node(_node.mid + 1, _node.r);
            }
            if (_node.add != 0) {
                Node left = _node.left;
                Node right = _node.right;
                left.add = _node.add;
                right.add = _node.add;
                left.v = left.r - left.l + 1;
                right.v = right.r - right.l + 1;
                _node.add = 0;
            }
        }

    }

    static class CountIntervals {
        private final SegmentTree tree = new SegmentTree();

        void add(int left, int right) {
            tree.modify(left, right, 1);
        }

        int count() {
            return tree.query(1, (int) 1e9);
        }

    }

}
