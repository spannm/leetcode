package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.RopeTreeNode;

/**
 * 2689. Extract Kth Character From The Rope Tree.
 */
class Problem2689 extends LeetcodeProblem {

    char getKthCharacter(RopeTreeNode root, int k) {
        return dfs(root).charAt(k - 1);
    }

    private String dfs(RopeTreeNode _root) {
        if (_root == null) {
            return "";
        }
        if (!_root.val.isEmpty()) {
            return _root.val;
        }
        String left = dfs(_root.left);
        String right = dfs(_root.right);
        return left + right;
    }

}
