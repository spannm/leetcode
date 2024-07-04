package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0549 extends LeetcodeProblem {

    private int max = 0;

    int longestConsecutive(TreeNode _root) {
        longestPath(_root);
        return max;
    }

    private int[] longestPath(TreeNode _root) {
        if (_root == null) {
            return new int[] {0, 0};
        }
        int increasing = 1;
        int decreasing = 1;
        if (_root.left != null) {
            int[] left = longestPath(_root.left);
            if (_root.val == _root.left.val + 1) {
                decreasing = left[1] + 1;
            } else if (_root.val == _root.left.val - 1) {
                increasing = left[0] + 1;
            }
        }

        if (_root.right != null) {
            int[] right = longestPath(_root.right);
            if (_root.val == _root.right.val + 1) {
                decreasing = Math.max(right[1] + 1, decreasing);
            } else if (_root.val == _root.right.val - 1) {
                increasing = Math.max(right[0] + 1, increasing);
            }
        }

        max = Math.max(max, decreasing + increasing - 1);
        return new int[] {increasing, decreasing};
    }

}
