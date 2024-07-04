package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0222 extends LeetcodeProblem {

    int countNodes(TreeNode _root) {
        int leftH = getLeftHeight(_root);
        int rightH = getRightHeight(_root);
        if (leftH == rightH) {
            return (1 << leftH) - 1;
        } else {
            return 1 + countNodes(_root.left) + countNodes(_root.right);
        }
    }

    static int getRightHeight(TreeNode _root) {
        int height = 0;
        while (_root != null) {
            _root = _root.right;
            height++;
        }
        return height;
    }

    static int getLeftHeight(TreeNode _root) {
        int height = 0;
        while (_root != null) {
            _root = _root.left;
            height++;
        }
        return height;
    }

}
