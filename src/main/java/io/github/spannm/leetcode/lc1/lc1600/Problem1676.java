package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.HashSet;
import java.util.Set;

class Problem1676 extends LeetcodeProblem {
    private TreeNode lca = null;

    TreeNode lowestCommonAncestor(TreeNode _root, TreeNode[] _nodes) {
        Set<Integer> target = new HashSet<>();
        for (TreeNode node : _nodes) {
            target.add(node.val);
        }
        dfs(_root, target);
        return lca;
    }

    private int dfs(TreeNode _root, Set<Integer> _target) {
        if (_root == null) {
            return 0;
        }
        int leftCount = dfs(_root.left, _target);
        int rightCount = dfs(_root.right, _target);
        int foundCount = leftCount + rightCount;
        if (_target.contains(_root.val)) {
            foundCount++;
        }
        if (foundCount == _target.size() && lca == null) {
            lca = _root;
        }
        return foundCount;
    }

}
