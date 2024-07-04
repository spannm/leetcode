package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem0366 extends LeetcodeProblem {

    private final List<List<Integer>> result = new ArrayList<>();

    List<List<Integer>> findLeaves(TreeNode _root) {
        dfs(_root);
        return result;
    }

    int dfs(TreeNode _root) {
        if (_root == null) {
            return 0;
        }
        int level = Math.max(dfs(_root.left), dfs(_root.right)) + 1;
        if (result.size() < level) {
            result.add(new ArrayList<>());
        }
        result.get(level - 1).add(_root.val);
        return level;
    }

}
