package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem1448 extends LeetcodeProblem {
    private int count;

    int goodNodes(TreeNode _root) {
        return dfs(_root, new PriorityQueue<>(Comparator.reverseOrder()));
    }

    int dfs(TreeNode _root, Queue<Integer> _maxHeap) {
        if (_root == null) {
            return count;
        }
        _maxHeap.offer(_root.val);
        if (_root.val >= _maxHeap.peek()) {
            count++;
        }
        if (_root.left != null) {
            dfs(_root.left, _maxHeap);
        }
        if (_root.right != null) {
            dfs(_root.right, _maxHeap);
        }
        _maxHeap.remove(_root.val);
        return count;
    }

}
