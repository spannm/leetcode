package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Problem0545 extends LeetcodeProblem {

    List<Integer> boundaryOfBinaryTree(TreeNode _root) {
        List<Integer> nodes = new ArrayList<>();
        if (_root == null) {
            return nodes;
        }

        nodes.add(_root.val);
        leftBoundary(_root.left, nodes);
        addLeaves(_root.left, nodes);
        addLeaves(_root.right, nodes);
        rightBoundary(_root.right, nodes);
        return nodes;
    }

    void leftBoundary(TreeNode _root, List<Integer> _nodes) {
        if (_root == null || _root.left == null && _root.right == null) {
            return;
        }
        _nodes.add(_root.val);
        if (_root.left == null) {
            leftBoundary(_root.right, _nodes);
        } else {
            leftBoundary(_root.left, _nodes);
        }
    }

    void rightBoundary(TreeNode _root, List<Integer> _nodes) {
        if (_root == null || _root.right == null && _root.left == null) {
            return;
        }
        rightBoundary(Objects.requireNonNullElseGet(_root.right, () -> _root.left), _nodes);
        _nodes.add(_root.val);
    }

    void addLeaves(TreeNode _root, List<Integer> _nodes) {
        if (_root == null) {
            return;
        }
        if (_root.left == null && _root.right == null) {
            _nodes.add(_root.val);
            return;
        }
        addLeaves(_root.left, _nodes);
        addLeaves(_root.right, _nodes);
    }

}
