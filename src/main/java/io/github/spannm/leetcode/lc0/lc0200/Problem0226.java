package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Problem0226 extends LeetcodeProblem {

    TreeNode invertTree(TreeNode _root) {
        if (_root == null || _root.left == null && _root.right == null) {
            return _root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(_root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
        return _root;
    }

}
