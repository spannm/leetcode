package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0298 extends LeetcodeProblem {

    private int max = 1;

    int longestConsecutive(TreeNode _root) {
        if (_root == null) {
            return 0;
        }
        dfs(_root, 0, _root.val);
        return max;
    }

    void dfs(TreeNode _root, int _curr, int _target) {
        if (_root == null) {
            return;
        }
        if (_root.val == _target) {
            _curr++;
        } else {
            _curr = 1;
        }
        max = Math.max(max, _curr);
        dfs(_root.left, _curr, _root.val + 1);
        dfs(_root.right, _curr, _root.val + 1);
    }

}
