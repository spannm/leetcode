package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Node;

import java.util.ArrayList;
import java.util.List;

class Problem0559 extends LeetcodeProblem {

    int maxDepth(Node _root) {
        int maxDepth = 0;
        if (_root == null) {
            return maxDepth;
        }
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(_root, currentPath, allPaths);
        for (List<Integer> path : allPaths) {
            maxDepth = Math.max(path.size(), maxDepth);
        }
        return maxDepth;
    }

    static void dfs(Node _root, List<Integer> _currentPath, List<List<Integer>> _allPaths) {
        if (_root == null) {
            _allPaths.add(new ArrayList<>(_currentPath));
        }
        if (_root.children != null && !_root.children.isEmpty()) {
            _currentPath.add(_root.val);
            for (Node child : _root.children) {
                dfs(child, new ArrayList<>(_currentPath), _allPaths);
            }
        }
        if (_root.children == null || _root.children.isEmpty()) {
            _currentPath.add(_root.val);
            _allPaths.add(new ArrayList<>(_currentPath));
        }
    }

}
