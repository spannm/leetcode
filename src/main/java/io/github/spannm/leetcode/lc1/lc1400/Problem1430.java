package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 1430. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree.
 */
class Problem1430 extends LeetcodeProblem {

    private int[] arr;

    boolean isValidSequence(TreeNode _root, int[] _arr) {
        arr = _arr;
        return dfs(_root, 0);
    }

    private boolean dfs(TreeNode root, int u) {
        if (root == null || root.val != arr[u]) {
            return false;
        } else if (u == arr.length - 1) {
            return root.left == null && root.right == null;
        }
        return dfs(root.left, u + 1) || dfs(root.right, u + 1);
    }

}
