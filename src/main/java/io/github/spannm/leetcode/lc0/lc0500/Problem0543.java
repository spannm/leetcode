package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

class Problem0543 extends LeetcodeProblem {

    int diameterOfBinaryTree(TreeNode _root) {
        AtomicInteger diameter = new AtomicInteger(0);
        dfs(_root, diameter);
        return diameter.get();
    }

    static int dfs(TreeNode _root, AtomicInteger _diameter) {
        if (_root == null) {
            return 0;
        }
        int leftPath = dfs(_root.left, _diameter);
        int rightPath = dfs(_root.right, _diameter);
        _diameter.set(Math.max(_diameter.get(), leftPath + rightPath));
        return Math.max(leftPath, rightPath) + 1;
    }

}
