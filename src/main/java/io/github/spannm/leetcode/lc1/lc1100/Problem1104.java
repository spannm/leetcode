package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

class Problem1104 extends LeetcodeProblem {

    List<Integer> pathInZigZagTree(int _label) {
        Deque<Integer> deque = buildZigZagOrderList(_label);
        TreeNode root = buildZigZagOrderTree(deque);
        return dfs(root, _label, new ArrayList<>());
    }

    private List<Integer> dfs(TreeNode _root, int _label, List<Integer> _list) {
        if (_root == null) {
            return _list;
        }
        _list.add(_root.val);
        if (_root.val == _label) {
            return _list;
        }
        dfs(_root.left, _label, _list);
        dfs(_root.right, _label, _list);
        if (_list.get(_list.size() - 1) == _label) {
            return _list;
        }
        _list.remove(_list.size() - 1);
        return _list;
    }

    private TreeNode buildZigZagOrderTree(Deque<Integer> _deque) {
        TreeNode root = new TreeNode(_deque.pollFirst());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!_deque.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                curr.left = new TreeNode(_deque.pollFirst());
                curr.right = new TreeNode(_deque.pollFirst());
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        return root;
    }

    private Deque<Integer> buildZigZagOrderList(int _label) {
        Deque<Integer> deque = new LinkedList<>();
        int num = 1;
        int level = 2;
        deque.add(num);
        do {
            num++;
            List<Integer> newLevel = new ArrayList<>();
            for (; num < Math.pow(2, level); num++) {
                newLevel.add(num);
            }
            num--;
            if (level % 2 == 0) {
                Collections.reverse(newLevel);
            }
            deque.addAll(newLevel);
            newLevel.clear();
            level++;
        } while (deque.getLast() < _label);
        return deque;
    }

}
