package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree.
 */
class Problem1457 extends LeetcodeProblem {

    int pseudoPalindromicPaths(TreeNode _root) {
        return dfs(_root, 0);
    }

    static int dfs(TreeNode _root, int _mask) {
        if (_root == null) {
            return 0;
        }
        _mask ^= 1 << _root.val;
        if (_root.left == null && _root.right == null) {
            return (_mask & (_mask - 1)) == 0 ? 1 : 0;
        }
        return dfs(_root.left, _mask) + dfs(_root.right, _mask);
    }

}
