package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0563 extends LeetcodeProblem {

    private int tilt = 0;

    int findTilt(TreeNode _root) {
        findTiltDfs(_root);
        return tilt;
    }

    int findTiltDfs(TreeNode _root) {
        if (_root == null) {
            return 0;
        }
        int leftTilt = 0;
        if (_root.left != null) {
            leftTilt = findTiltDfs(_root.left);
        }
        int rightTilt = 0;
        if (_root.right != null) {
            rightTilt = findTiltDfs(_root.right);
        }
        if (_root.left == null && _root.right == null) {
            return _root.val;
        }
        tilt += Math.abs(leftTilt - rightTilt);
        return leftTilt + rightTilt + _root.val;
    }

}
