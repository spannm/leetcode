package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1660. Correct a Binary Tree.
 */
class Problem1660 extends LeetcodeProblem {

    private final Set<TreeNode> vis = new HashSet<>();

    TreeNode correctBinaryTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null || vis.contains(root.right)) {
            return null;
        }
        vis.add(root);
        root.right = dfs(root.right);
        root.left = dfs(root.left);
        return root;
    }

}
