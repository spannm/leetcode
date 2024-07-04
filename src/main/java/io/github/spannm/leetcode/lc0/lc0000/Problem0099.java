package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/recover-binary-search-tree/">99. Recover Binary Search Tree</a>.
 */
class Problem0099 extends LeetcodeProblem {

    private TreeNode first  = null;
    private TreeNode second = null;
    private TreeNode pre    = null;

    void recoverTree(TreeNode _root) {
        if (_root == null) {
            return;
        }

        inorder(_root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void inorder(TreeNode _root) {
        if (_root == null) {
            return;
        }
        inorder(_root.left);

        if (first == null && (pre == null || pre.val >= _root.val)) {
            first = pre;
        }

        if (first != null && pre.val >= _root.val) {
            second = _root;
        }

        pre = _root;
        inorder(_root.right);
    }

}
