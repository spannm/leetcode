package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">1512. Number of Good Pairs</a>.
 */
class Problem0102 extends LeetcodeProblem {

    List<List<Integer>> levelOrder(final TreeNode _root) {
        if (_root == null) {
            return List.of();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(_root);
        while (!q.isEmpty()) {
            List<Integer> currLvl = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                currLvl.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            result.add(currLvl);
        }
        return result;
    }

}
