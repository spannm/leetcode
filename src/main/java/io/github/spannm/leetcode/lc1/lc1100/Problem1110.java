package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem1110 extends LeetcodeProblem {

    List<TreeNode> delNodes(TreeNode _root, int[] _toDelete) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(_root);
        for (int d : _toDelete) {
            delete(d, queue);
        }
        List<TreeNode> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }

    private void delete(int _toDelete, Queue<TreeNode> _queue) {
        int size = _queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode curr = _queue.poll();
            if (delete(curr, _toDelete, _queue)) {
                if (_toDelete != curr.val) {
                    _queue.offer(curr);
                }
                break;
            } else {
                _queue.offer(curr);
            }
        }
    }

    private boolean delete(TreeNode _curr, int _toDelete, Queue<TreeNode> _queue) {
        if (_curr == null) {
            return false;
        } else {
            if (_curr.val == _toDelete) {
                if (_curr.left != null) {
                    _queue.offer(_curr.left);
                }
                if (_curr.right != null) {
                    _queue.offer(_curr.right);
                }
                return true;
            } else if (_curr.left != null && _curr.left.val == _toDelete) {
                if (_curr.left.left != null) {
                    _queue.offer(_curr.left.left);
                }
                if (_curr.left.right != null) {
                    _queue.offer(_curr.left.right);
                }
                _curr.left = null;
                return true;
            } else if (_curr.right != null && _curr.right.val == _toDelete) {
                if (_curr.right.left != null) {
                    _queue.offer(_curr.right.left);
                }
                if (_curr.right.right != null) {
                    _queue.offer(_curr.right.right);
                }
                _curr.right = null;
                return true;
            }
            return delete(_curr.left, _toDelete, _queue) || delete(_curr.right, _toDelete, _queue);
        }
    }

}
