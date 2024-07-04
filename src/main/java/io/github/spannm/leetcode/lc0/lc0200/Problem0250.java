package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0250 extends LeetcodeProblem {

    int countUnivalSubtrees(TreeNode _root) {
        int[] count = new int[1];
        helper(_root, count);
        return count[0];
    }

    private boolean helper(TreeNode _node, int[] _count) {
        if (_node == null) {
            return true;
        }
        boolean left = helper(_node.left, _count);
        boolean right = helper(_node.right, _count);
        if (left && right) {
            if (_node.left != null && _node.val != _node.left.val || _node.right != null && _node.val != _node.right.val) {
                return false;
            }
            _count[0]++;
            return true;
        }
        return false;
    }

}
