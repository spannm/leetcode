package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0450 extends LeetcodeProblem {

    TreeNode deleteNode(TreeNode _root, int _key) {
        if (_root == null) {
            return null;
        } else if (_root.val > _key) {
            _root.left = deleteNode(_root.left, _key);
        } else if (_root.val < _key) {
            _root.right = deleteNode(_root.right, _key);
        } else {
            if (_root.left == null) {
                return _root.right;
            } else if (_root.right == null) {
                return _root.left;
            }

            TreeNode minNode = getMin(_root.right);
            _root.val = minNode.val;
            _root.right = deleteNode(_root.right, _root.val);
        }
        return _root;
    }

    static TreeNode getMin(TreeNode _node) {
        while (_node.left != null) {
            _node = _node.left;
        }
        return _node;
    }

}
