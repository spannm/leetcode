package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem1145 extends LeetcodeProblem {

    boolean btreeGameWinningMove(TreeNode _root, int _n, int _x) {
        if (_root == null) {
            return false;
        }

        if (_root.val == _x) {

            int leftCount = countNodes(_root.left);
            int rightCount = countNodes(_root.right);
            int parent = _n - (leftCount + rightCount + 1);

            return parent > leftCount + rightCount || leftCount > parent + rightCount || rightCount > parent + leftCount;
        }
        return btreeGameWinningMove(_root.left, _n, _x) || btreeGameWinningMove(_root.right, _n, _x);
    }

    private int countNodes(TreeNode _root) {
        if (_root == null) {
            return 0;
        }
        return countNodes(_root.left) + countNodes(_root.right) + 1;
    }

}
