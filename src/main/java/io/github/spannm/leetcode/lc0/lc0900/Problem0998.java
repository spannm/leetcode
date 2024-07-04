package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 998. Maximum Binary Tree II.
 */
class Problem0998 extends LeetcodeProblem {

    TreeNode insertIntoMaxTree(TreeNode _root, int _val) {
        if (_root == null || _root.val < _val) {
            return new TreeNode(_val, _root, null);
        }
        _root.right = insertIntoMaxTree(_root.right, _val);
        return _root;
    }

}
