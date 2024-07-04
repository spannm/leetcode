package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximum-width-of-binary-tree/">662. Maximum Width of Binary Tree</a>.
 */
class Problem0662 extends LeetcodeProblem {

    int widthOfBinaryTree(TreeNode _root) {
        return searchTree(new LinkedList<>(List.of(_root)));
    }

    static int searchTree(Deque<TreeNode> _queue) {
        MaxInteger maxWidth = new MaxInteger(1);
        while (!_queue.isEmpty()) {
            final int sz = _queue.size();
            int left = _queue.peek().val;
            int right = left;
            for (int i = 0; i < sz; i++) {
                TreeNode node = _queue.removeFirst();

                if (node.left != null) {
                    node.left.val = node.val * 2 - 1;
                    _queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2;
                    _queue.add(node.right);
                }
                if (i == sz - 1) {
                    right = node.val;
                }
            }
            maxWidth.setVal(right - left + 1);
        }
        return maxWidth.intValue();
    }

    static final class MaxInteger extends Number {
        private static final long serialVersionUID = 1L;
        private int               val;

        MaxInteger(int _val) {
            val = _val;
        }

        int getVal() {
            return val;
        }

        void setVal(int _val) {
            if (_val > val) {
                val = _val;
            }
        }

        @Override
        public int intValue() {
            return getVal();
        }

        @Override
        public long longValue() {
            return getVal();
        }

        @Override
        public float floatValue() {
            return getVal();
        }

        @Override
        public double doubleValue() {
            return getVal();
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }

    }

}
