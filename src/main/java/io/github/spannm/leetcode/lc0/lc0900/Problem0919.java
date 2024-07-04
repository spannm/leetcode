package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Problem0919 extends LeetcodeProblem {

    static class CBTInserter {
        private final List<TreeNode> tree;

        CBTInserter(TreeNode _root) {
            tree = new ArrayList<>();
            Deque<TreeNode> q = new ArrayDeque<>();
            q.offer(_root);
            while (!q.isEmpty()) {
                TreeNode node = q.pollFirst();
                tree.add(node);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        int insert(int _val) {
            int pid = tree.size() - 1 >> 1;
            TreeNode node = new TreeNode(_val);
            tree.add(node);
            TreeNode p = tree.get(pid);
            if (p.left == null) {
                p.left = node;
            } else {
                p.right = node;
            }
            return p.val;
        }

        @SuppressWarnings("MethodNameCheck")
        TreeNode get_root() {
            return tree.get(0);
        }

    }

}
