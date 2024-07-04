package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0270 extends LeetcodeProblem {

    int closestValue(TreeNode _root, double _target) {
        if (_root == null) {
            return 0;
        }
        double delta = Double.MAX_VALUE;
        return dfs(_root, _target, delta, _root.val);
    }

    private int dfs(TreeNode _root, double _target, double _delta, int _closestVal) {
        if (Math.abs(_root.val - _target) < _delta) {
            _closestVal = _root.val;
            _delta = Math.abs(_root.val - _target);
        }
        int leftVal = _closestVal;
        if (_root.left != null) {
            leftVal = dfs(_root.left, _target, _delta, _closestVal);
        }
        int rightVal = _closestVal;
        if (_root.right != null) {
            rightVal = dfs(_root.right, _target, _delta, _closestVal);
        }
        return Math.abs(leftVal - _target) > Math.abs(rightVal - _target) ? rightVal : leftVal;
    }

}
