package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/path-sum-ii/">113. Path Sum II</a>.
 */
class Problem0113 extends LeetcodeProblem {

    List<List<Integer>> pathSum(final TreeNode _root, final int _sum) {
        if (_root == null) {
            return List.of();
        }
        return dfs(_root, new ArrayList<>(), new ArrayList<>(), _sum);
    }

    static List<List<Integer>> dfs(TreeNode _root, List<Integer> _path, List<List<Integer>> _allPaths, int _sum) {
        _path.add(_root.val);
        if (_root.left != null) {
            dfs(_root.left, _path, _allPaths, _sum - _root.val);
        }
        if (_root.right != null) {
            dfs(_root.right, _path, _allPaths, _sum - _root.val);
        }
        if (_root.left == null && _root.right == null) {
            if (_sum == _root.val) {
                _allPaths.add(new ArrayList<>(_path));
            }
        }
        _path.remove(_path.size() - 1);
        return _allPaths;
    }

}
