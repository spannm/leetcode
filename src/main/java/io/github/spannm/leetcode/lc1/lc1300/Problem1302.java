package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Problem1302 extends LeetcodeProblem {

    int deepestLeavesSum(TreeNode _root) {
        int depth = maxDepth(_root);
        return bfs(_root, depth);
    }

    private int bfs(TreeNode _root, int _depth) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(_root);
        int currentLevel = 0;
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            currentLevel++;
            for (int i = 0; i < size; i++) {
                TreeNode currNode = queue.poll();
                if (currentLevel == _depth) {
                    sum += currNode.val;
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
        }
        return sum;
    }

    private int maxDepth(TreeNode _root) {
        if (_root == null) {
            return 0;
        }
        return Math.max(maxDepth(_root.left), maxDepth(_root.right)) + 1;
    }

}
