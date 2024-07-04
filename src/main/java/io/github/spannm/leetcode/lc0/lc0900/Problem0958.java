package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/check-completeness-of-a-binary-tree/">958. Check Completeness of a Binary
 * Tree</a>.
 */
class Problem0958 extends LeetcodeProblem {

    boolean isCompleteTree(TreeNode _root) {
        // a null/empty tree is complete
        if (_root == null) {
            return true;
        }

        // create queue to store tree nodes in level order
        final Queue<TreeNode> q = new LinkedList<>();
        q.add(_root);

        // traverse tree in level order
        while (q.peek() != null) {
            // remove the first node from the queue
            TreeNode node = q.poll();
            // add left and right child nodes of current node to queue
            q.offer(node.left);
            q.offer(node.right);
        }

        // remove any remaining null nodes from end of queue
        while (!q.isEmpty() && q.peek() == null) {
            q.poll();
        }

        // Check if there are remaining nodes in queue
        // If so, tree is incomplete
        return q.isEmpty();
    }

}
