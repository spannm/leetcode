package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">124. Binary Tree Maximum Path Sum</a>.
 */
class Problem0124 extends LeetcodeProblem {

    int maxPathSum(TreeNode _root) {
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        dfs(_root, max);
        return max.get();
    }

    static int dfs(TreeNode _root, AtomicInteger _max) {
        if (_root == null) {
            return 0;
        }

        int left = Math.max(dfs(_root.left, _max), 0);
        int right = Math.max(dfs(_root.right, _max), 0);

        _max.set(Math.max(_max.get(), _root.val + left + right));

        return _root.val + Math.max(left, right);
    }

}
