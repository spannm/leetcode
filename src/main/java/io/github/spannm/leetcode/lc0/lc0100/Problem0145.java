package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal/">145. Binary Tree Postorder Traversal</a>.
 */
class Problem0145 extends LeetcodeProblem {

    List<Integer> postorderTraversal(TreeNode _root) {
        if (_root == null) {
            return List.of();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(_root);
        while (!stack.isEmpty()) {
            _root = stack.pop();
            result.add(_root.val);
            if (_root.left != null) {
                stack.push(_root.left);
            }
            if (_root.right != null) {
                stack.push(_root.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
