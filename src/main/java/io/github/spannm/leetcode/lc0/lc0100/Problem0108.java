package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">108. Convert Sorted Array to
 * Binary Search Tree</a>.
 */
class Problem0108 extends LeetcodeProblem {

    TreeNode sortedArrayToBST(int[] _num) {
        return dfs(_num, 0, _num.length - 1);
    }

    static TreeNode dfs(int[] _num, int _left, int _right) {
        if (_left > _right) {
            return null;
        }
        int mid = _left + (_right - _left) / 2;
        TreeNode node = new TreeNode(_num[mid]);
        node.left = dfs(_num, _left, mid - 1);
        node.right = dfs(_num, mid + 1, _right);
        return node;
    }

}
