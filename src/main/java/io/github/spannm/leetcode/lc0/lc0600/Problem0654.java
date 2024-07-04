package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0654 extends LeetcodeProblem {

    TreeNode constructMaximumBinaryTree(int[] _nums) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < _nums.length; i++) {
            if (_nums[i] > max) {
                max = _nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        return constructMaxTree(root, maxIndex, _nums, 0, _nums.length - 1);
    }

    static TreeNode constructMaxTree(TreeNode _root, int _rootIndex, int[] _nums, int _start, int _end) {
        if (_rootIndex > _start) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int i = _start; i < _rootIndex; i++) {
                if (max < _nums[i]) {
                    max = _nums[i];
                    maxIndex = i;
                }
            }
            _root.left = constructMaxTree(new TreeNode(max), maxIndex, _nums, _start, _rootIndex - 1);
        }
        if (_rootIndex < _end) {
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int i = _rootIndex + 1; i <= _end; i++) {
                if (max < _nums[i]) {
                    max = _nums[i];
                    maxIndex = i;
                }
            }
            _root.right = constructMaxTree(new TreeNode(max), maxIndex, _nums, _rootIndex + 1, _end);
        }
        return _root;
    }

}
