package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">104. Maximum Depth of Binary Tree</a>.
 */
class Problem0104 extends LeetcodeProblem {

    int maxDepth(TreeNode _root) {
        // null means tree does not exist
        // Get the depth of the left and right subtree using recursion,
        // then choose the larger depth and add root (+1)
        return _root == null ? 0 : Math.max(maxDepth(_root.left), maxDepth(_root.right)) + 1;
    }

}
