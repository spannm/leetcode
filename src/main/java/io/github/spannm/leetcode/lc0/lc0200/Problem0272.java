package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Problem0272 extends LeetcodeProblem {

    List<Integer> closestKValues(TreeNode _root, double _target, int _k) {
        List<Integer> res = new ArrayList<>();

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        inorder(_root, _target, false, s1);
        inorder(_root, _target, true, s2);

        while (_k-- > 0) {
            if (s1.isEmpty()) {
                res.add(s2.pop());
            } else if (s2.isEmpty()) {
                res.add(s1.pop());
            } else if (Math.abs(s1.peek() - _target) < Math.abs(s2.peek() - _target)) {
                res.add(s1.pop());
            } else {
                res.add(s2.pop());
            }
        }

        return res;
    }

    void inorder(TreeNode _root, double _target, boolean _reverse, Stack<Integer> _stack) {
        if (_root == null) {
            return;
        }

        inorder(_reverse ? _root.right : _root.left, _target, _reverse, _stack);

        if (_reverse && _root.val <= _target || !_reverse && _root.val > _target) {
            return;
        }

        _stack.push(_root.val);
        inorder(_reverse ? _root.left : _root.right, _target, _reverse, _stack);
    }

}
