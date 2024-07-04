package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem1469 extends LeetcodeProblem {

    List<Integer> getLonelyNodes(TreeNode _root) {
        List<Integer> lonelyNodes = new ArrayList<>();
        dfs(_root, lonelyNodes);
        return lonelyNodes;
    }

    private static void dfs(TreeNode _root, List<Integer> _lonelyNodes) {
        if (_root == null) {
            return;
        }

        if (_root.left == null && _root.right != null) {
            _lonelyNodes.add(_root.right.val);
        }

        if (_root.left != null && _root.right == null) {
            _lonelyNodes.add(_root.left.val);
        }

        dfs(_root.left, _lonelyNodes);
        dfs(_root.right, _lonelyNodes);
    }

}
