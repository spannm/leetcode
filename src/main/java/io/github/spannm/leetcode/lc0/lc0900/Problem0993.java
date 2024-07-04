package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Problem0993 extends LeetcodeProblem {

    boolean isCousins(TreeNode _root, int _x, int _y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(_root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                if (current.left != null && current.right != null) {
                    if (current.left.val == _x && current.right.val == _y
                        || current.left.val == _y && current.right.val == _x) {
                        return false;
                    }
                }
            }
            if (checkQueue(queue, _x, _y)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkQueue(Queue<TreeNode> _queue, int _x, int _y) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> tmp = new LinkedList<>(_queue);
        while (!tmp.isEmpty()) {
            set.add(tmp.poll().val);
        }
        return set.contains(_x) && set.contains(_y);
    }

}
