package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 558. Logical OR of Two Binary Grids Represented as Quad-Trees.
 */
class Problem0558 extends LeetcodeProblem {

    Node intersect(Node _quadTree1, Node _quadTree2) {
        return dfs(_quadTree1, _quadTree2);
    }

    static Node dfs(Node _t1, Node _t2) {
        if (_t1.isLeaf && _t2.isLeaf) {
            return new Node(_t1.val || _t2.val, true);
        } else if (_t1.isLeaf) {
            return _t1.val ? _t1 : _t2;
        } else if (_t2.isLeaf) {
            return _t2.val ? _t2 : _t1;
        }

        Node res = new Node();
        res.topLeft = dfs(_t1.topLeft, _t2.topLeft);
        res.topRight = dfs(_t1.topRight, _t2.topRight);
        res.bottomLeft = dfs(_t1.bottomLeft, _t2.bottomLeft);
        res.bottomRight = dfs(_t1.bottomRight, _t2.bottomRight);
        boolean isLeaf = res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomLeft.isLeaf
            && res.bottomRight.isLeaf;
        boolean sameVal = res.topLeft.val == res.topRight.val
            && res.topRight.val == res.bottomLeft.val && res.bottomLeft.val == res.bottomRight.val;
        if (isLeaf && sameVal) {
            res = res.topLeft;
        }
        return res;
    }

    static class Node {
        private boolean val;
        private boolean isLeaf;
        private Node    topLeft;
        private Node    topRight;
        private Node    bottomLeft;
        private Node    bottomRight;

        Node() {
        }

        Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }

        Node(boolean _val, boolean _isLeaf) {
            val = _val;
            isLeaf = _isLeaf;
        }
    }

}
