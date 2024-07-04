package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/">107. Binary Tree Level Order Traversal
 * II</a>.
 */
class Problem0107 extends LeetcodeProblem {

    List<List<Integer>> levelOrderBottom(TreeNode _root) {
        if (_root == null) {
            return List.of();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(_root);
        while (!q.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<>();
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = q.poll();
                thisLevel.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            result.add(thisLevel);
        }
        Collections.reverse(result);
        return result;
    }

}
