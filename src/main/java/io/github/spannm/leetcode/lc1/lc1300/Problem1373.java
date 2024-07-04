package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem1373 extends LeetcodeProblem {

    int maxSumBST(TreeNode _root) {
        return postOrder(_root)[4];
    }

    private int[] postOrder(TreeNode _root) {
        if (_root == null) {
            return new int[] {1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] leftSide = postOrder(_root.left);
        int[] rightSide = postOrder(_root.right);
        int localMax = Math.max(leftSide[4], rightSide[4]);
        if (leftSide[0] == 1 && rightSide[0] == 1 && _root.val > leftSide[3] && _root.val < rightSide[2]) {
            int sum = _root.val + leftSide[1] + rightSide[1];
            return new int[] {1, sum, leftSide[2] == Integer.MAX_VALUE ? _root.val : leftSide[2], rightSide[3] == Integer.MIN_VALUE ? _root.val : rightSide[3], Math.max(localMax, sum)};
        } else {
            return new int[] {0, 0, 0, 0, localMax};
        }
    }

}
