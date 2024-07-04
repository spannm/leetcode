package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/">1372. Longest ZigZag Path in a Binary
 * Tree</a>.
 */
class Problem1372 extends LeetcodeProblem {

    final int longestZigZag(final TreeNode _root) {
        return Math.max(longestZigZagImpl(_root, true, 0), longestZigZagImpl(_root, false, 0));
    }

    static int longestZigZagImpl(final TreeNode _root, final boolean _left, final int _currLen) {
        if (_root == null) {
            return _currLen - 1;
        } else if (_root.left == null && _root.right == null) {
            return _currLen;
        } else if (_left) {
            return Math.max(
                longestZigZagImpl(_root.left, false, _currLen + 1),
                longestZigZagImpl(_root.right, true, 1));
        } else {
            return Math.max(
                longestZigZagImpl(_root.right, true, _currLen + 1),
                longestZigZagImpl(_root.left, false, 1));
        }
    }

}
