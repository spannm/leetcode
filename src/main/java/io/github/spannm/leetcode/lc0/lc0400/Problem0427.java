package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/construct-quad-tree/">427. Construct Quad Tree</a>.
 */
class Problem0427 extends LeetcodeProblem {

    Node construct(int[][] _grid) {
        return constructImpl(_grid, 0, 0, _grid.length);
    }

    Node constructImpl(final int[][] _grid, final int _x, final int _y, final int _len) {
        if (_len == 1) {
            return new Node(_grid[_x][_y] != 0, true, null, null, null, null);
        }

        final int halfLen = _len / 2;
        Node node = new Node();
        Node topLeft = constructImpl(_grid, _x, _y, halfLen);
        Node topRight = constructImpl(_grid, _x, _y + halfLen, halfLen);
        Node bottomLeft = constructImpl(_grid, _x + halfLen, _y, halfLen);
        Node bottomRight = constructImpl(_grid, _x + halfLen, _y + halfLen, halfLen);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
            && topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val) {
            node.isLeaf = true;
            node.val = topLeft.val;
        } else {
            node.topLeft = topLeft;
            node.topRight = topRight;
            node.bottomLeft = bottomLeft;
            node.bottomRight = bottomRight;
        }
        return node;
    }

    static class Node {
        private boolean val;
        private boolean isLeaf;
        private Node    topLeft;
        private Node    topRight;
        private Node    bottomLeft;
        private Node    bottomRight;

        Node() {
            this(false, false, null, null, null, null);
        }

        Node(boolean _val, boolean _isLeaf) {
            this(_val, _isLeaf, null, null, null, null);
        }

        Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }

        @Override
        public String toString() {
            return String.format("%s[val=%s, leaf=%s, topLeft=%s, topRight=%s, bottomLeft=%s, bottomRight=%s]",
                getClass().getSimpleName(), val, isLeaf, topLeft, topRight, bottomLeft, bottomRight);
        }

    }

}
