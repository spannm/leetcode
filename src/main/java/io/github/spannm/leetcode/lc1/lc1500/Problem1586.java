package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem1586 extends LeetcodeProblem {

    static class BSTIterator {
        private final List<Integer> nums = new ArrayList<>();
        private int                 i    = -1;

        BSTIterator(TreeNode _root) {
            dfs(_root);
        }

        boolean hasNext() {
            return i < nums.size() - 1;
        }

        int next() {
            return nums.get(++i);
        }

        boolean hasPrev() {
            return i > 0;
        }

        int prev() {
            return nums.get(--i);
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            nums.add(root.val);
            dfs(root.right);
        }

    }

}
