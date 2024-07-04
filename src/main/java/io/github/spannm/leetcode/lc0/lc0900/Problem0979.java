package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

class Problem0979 extends LeetcodeProblem {

    int distributeCoins(TreeNode _root) {
        AtomicInteger moves = new AtomicInteger(0);
        dfs(_root, moves);
        return moves.get();
    }

    static int dfs(TreeNode _root, AtomicInteger _moves) {
        if (_root == null) {
            return 0;
        }
        int left = dfs(_root.left, _moves);
        int right = dfs(_root.right, _moves);
        _moves.addAndGet(Math.abs(left) + Math.abs(right));
        return _root.val + left + right - 1;
    }

}
