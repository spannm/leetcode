package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0538 extends LeetcodeProblem {

    TreeNode convertBST(TreeNode _root) {
        dfs(_root, 0);
        return _root;
    }

    static int dfs(TreeNode _root, int _val) {
        if (_root == null) {
            return _val;
        }
        _root.val += dfs(_root.right, _val);
        return dfs(_root.left, _root.val);
    }

}
