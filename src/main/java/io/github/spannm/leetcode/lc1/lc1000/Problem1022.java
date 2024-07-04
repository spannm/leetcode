package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem1022 extends LeetcodeProblem {

    int sumRootToLeaf(TreeNode _root) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(_root, paths, new ArrayList<>());
        int sum = 0;
        for (List<Integer> list : paths) {
            int num = 0;
            for (int i : list) {
                num = (num << 1) + i;
            }
            sum += num;
        }
        return sum;
    }

    private static void dfs(TreeNode _root, List<List<Integer>> _paths, List<Integer> _path) {
        _path.add(_root.val);
        if (_root.left != null) {
            dfs(_root.left, _paths, _path);
            _path.remove(_path.size() - 1);
        }
        if (_root.right != null) {
            dfs(_root.right, _paths, _path);
            _path.remove(_path.size() - 1);
        }
        if (_root.left == null && _root.right == null) {
            _paths.add(new ArrayList<>(_path));
        }
    }

}
