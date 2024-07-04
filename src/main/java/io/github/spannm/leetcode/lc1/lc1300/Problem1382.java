package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem1382 extends LeetcodeProblem {

    TreeNode balanceBST(TreeNode _root) {
        List<Integer> inorder = inorder(_root, new ArrayList<>());
        return dfs(inorder, 0, inorder.size() - 1);
    }

    static List<Integer> inorder(TreeNode _root, List<Integer> _list) {
        if (_root == null) {
            return _list;
        }
        inorder(_root.left, _list);
        _list.add(_root.val);
        return inorder(_root.right, _list);
    }

    static TreeNode dfs(List<Integer> _nums, int _start, int _end) {
        if (_end < _start) {
            return null;
        }
        int mid = (_start + _end) / 2;
        TreeNode root = new TreeNode(_nums.get(mid));
        root.left = dfs(_nums, _start, mid - 1);
        root.right = dfs(_nums, mid + 1, _end);
        return root;
    }

}
