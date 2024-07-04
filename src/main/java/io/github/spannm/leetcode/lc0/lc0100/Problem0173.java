package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-search-tree-iterator/">173. Binary Search Tree Iterator</a>.
 */
class Problem0173 extends LeetcodeProblem {

    static class BSTIterator {
        private final Queue<Integer> q;

        BSTIterator(TreeNode _root) {
            q = new LinkedList<>();
            if (_root != null) {
                dfs(_root, q);
            }
        }

        private static void dfs(TreeNode _root, Queue<Integer> _q) {
            if (_root.left != null) {
                dfs(_root.left, _q);
            }
            _q.offer(_root.val);
            if (_root.right != null) {
                dfs(_root.right, _q);
            }
        }

        boolean hasNext() {
            return !q.isEmpty();
        }

        int next() {
            return q.poll();
        }
    }

}
