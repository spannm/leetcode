package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/find-largest-value-in-each-tree-row/">515. Find Largest Value in Each Tree
 * Row</a>.
 */
class Problem0515 extends LeetcodeProblem {

    List<Integer> largestValues(TreeNode _root) {
        if (_root == null) {
            return List.of();
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int max;
        int size;
        queue.offer(_root);
        while (!queue.isEmpty()) {
            max = Integer.MIN_VALUE;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                max = Math.max(max, curr.val);
                java.util.Optional.ofNullable(curr.left).ifPresent(queue::offer);
                java.util.Optional.ofNullable(curr.right).ifPresent(queue::offer);
            }
            list.add(max);
        }
        return list;
    }

}
