package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">103. Binary Tree Zigzag Level Order
 * Traversal</a>.
 */
class Problem0103 extends LeetcodeProblem {

    List<List<Integer>> zigzagLevelOrder(TreeNode _root) {
        if (_root == null) {
            return List.of();
        }
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(_root);
        boolean forward = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> lvl = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                lvl.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            if (!forward) {
                Collections.reverse(lvl);
            }
            forward = !forward;
            levels.add(lvl);
        }
        return levels;
    }

}
