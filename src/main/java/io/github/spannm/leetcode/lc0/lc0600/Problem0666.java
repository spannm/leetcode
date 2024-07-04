package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0666 extends LeetcodeProblem {
    private int totalSum = 0;

    int pathSum(int[] _nums) {
        TreeNode root = constructTree(_nums);
        if (root == null) {
            return 0;
        }
        computePathSum(root, 0);
        return totalSum;
    }

    private void computePathSum(TreeNode _root, int _pathSum) {
        _pathSum += _root.val;
        if (_root.left != null) {
            computePathSum(_root.left, _pathSum);
        }
        if (_root.right != null) {
            computePathSum(_root.right, _pathSum);
        }
        if (_root.left == null && _root.right == null) {
            totalSum += _pathSum;
        }
    }

    private TreeNode constructTree(int[] _nums) {
        if (_nums == null || _nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(Integer.toString(_nums[0]).substring(2, 3)));

        for (int i = 1; i < _nums.length; i++) {
            if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 2 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 1) {
                root.left = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            } else if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 2 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 2) {
                root.right = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            }
        }

        for (int i = 2; i < _nums.length; i++) {
            if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 3 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 1) {
                root.left.left = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            } else if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 3 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 2) {
                root.left.right = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            } else if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 3 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 3) {
                root.right.left = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            } else if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 3 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 4) {
                root.right.right = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            }
        }

        for (int i = 3; i < _nums.length; i++) {
            if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 4 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 1) {
                root.left.left.left = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            } else if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 4 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 2) {
                root.left.left.right = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            } else if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 4 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 3) {
                root.left.right.left = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            } else if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 4 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 4) {
                root.left.right.right = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            } else if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 4 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 5) {
                root.right.left.left = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            } else if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 4 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 6) {
                root.right.left.right = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            } else if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 4 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 7) {
                root.right.right.left = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            } else if (Integer.parseInt(Integer.toString(_nums[i]).substring(0, 1)) == 4 && Integer.parseInt(Integer.toString(_nums[i]).substring(1, 2)) == 8) {
                root.right.right.right = new TreeNode(Integer.parseInt(Integer.toString(_nums[i]).substring(2, 3)));
            }
        }

        return root;
    }

}
