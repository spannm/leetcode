package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.TreeSet;

class Problem0671 extends LeetcodeProblem {

    int findSecondMinimumValue(TreeNode _root) {
        TreeSet<Integer> set = new TreeSet<>();
        dfs(_root, set);
        if (set.size() < 2) {
            return -1;
        }
        set.pollFirst();
        return set.pollFirst();
    }

    private static void dfs(TreeNode _root, TreeSet<Integer> _set) {
        if (_root == null) {
            return;
        }
        _set.add(_root.val);
        dfs(_root.left, _set);
        dfs(_root.right, _set);
    }

}
