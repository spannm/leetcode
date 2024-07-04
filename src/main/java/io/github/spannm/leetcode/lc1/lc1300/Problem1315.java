package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem1315 extends LeetcodeProblem {

    int sumEvenGrandparent(TreeNode _root) {
        return _root == null ? 0 : dfs(_root, _root.left, 0) + dfs(_root, _root.right, 0);
    }

    private static int dfs(TreeNode _grandParent, TreeNode _parent, int _sum) {
        if (_grandParent == null || _parent == null) {
            return _sum;
        } else if (_grandParent.val % 2 == 0 && _parent.left != null) {
            _sum += _parent.left.val;
        }
        if (_grandParent.val % 2 == 0 && _parent.right != null) {
            _sum += _parent.right.val;
        }
        _sum = dfs(_parent, _parent.left, _sum);
        _sum = dfs(_parent, _parent.right, _sum);
        return _sum;
    }

}
