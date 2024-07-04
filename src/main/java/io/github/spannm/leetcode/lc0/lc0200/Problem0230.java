package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem0230 extends LeetcodeProblem {

    int kthSmallest(TreeNode _root, int _k) {
        List<Integer> inorder = new ArrayList<>();
        dfs(_root, inorder, _k);
        return inorder.get(_k - 1);
    }

    static void dfs(TreeNode _root, List<Integer> _list, int _k) {
        if (_root == null) {
            return;
        }
        dfs(_root.left, _list, _k);
        _list.add(_root.val);
        dfs(_root.right, _list, _k);
    }

}
