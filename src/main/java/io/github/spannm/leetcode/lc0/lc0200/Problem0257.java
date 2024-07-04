package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem0257 extends LeetcodeProblem {

    List<String> binaryTreePaths(TreeNode _root) {
        return _root == null ? List.of() : dfs(_root, new ArrayList<>(), "");
    }

    private static List<String> dfs(TreeNode _root, List<String> _paths, String _path) {
        if (_root.left == null && _root.right == null) {
            _paths.add(_path + _root.val);
            return _paths;
        }
        _path += _root.val + "->";
        if (_root.left != null) {
            dfs(_root.left, _paths, _path);
        }
        if (_root.right != null) {
            dfs(_root.right, _paths, _path);
        }
        return _paths;
    }

}
