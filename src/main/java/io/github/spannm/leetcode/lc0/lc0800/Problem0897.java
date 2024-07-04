package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem0897 extends LeetcodeProblem {

    TreeNode increasingBST(TreeNode _root) {
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(_root, inorderList);
        return constructTree(inorderList);
    }

    private TreeNode constructTree(List<Integer> _inorderList) {
        if (_inorderList.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(_inorderList.get(0));
        TreeNode tmp = root;
        for (int i = 1; i < _inorderList.size(); i++) {
            tmp.right = new TreeNode(_inorderList.get(i));
            tmp = tmp.right;
        }
        return root;
    }

    private void inorderTraversal(TreeNode _root, List<Integer> _inorderList) {
        if (_root == null) {
            return;
        }
        if (_root.left != null) {
            inorderTraversal(_root.left, _inorderList);
        }
        _inorderList.add(_root.val);
        if (_root.right != null) {
            inorderTraversal(_root.right, _inorderList);
        }
    }

}
