package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Problem0513 extends LeetcodeProblem {

    int findBottomLeftValue(TreeNode _root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(_root);
        TreeNode leftMost = _root;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (i == 0) {
                    leftMost = curr;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return leftMost.val;
    }

}
