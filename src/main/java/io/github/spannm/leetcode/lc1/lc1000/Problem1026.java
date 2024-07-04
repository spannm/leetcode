package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem1026 extends LeetcodeProblem {
    private int maxDiff = 0;

    int maxAncestorDiff(TreeNode _root) {
        dfs(_root);
        return maxDiff;
    }

    private void dfs(TreeNode _root) {
        if (_root == null) {
            return;
        }
        int[] minMax = new int[] {_root.val, _root.val};
        findMinMax(_root, minMax);
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(_root.val - minMax[0]), Math.abs(minMax[1] - _root.val)));
        dfs(_root.left);
        dfs(_root.right);
    }

    private int[] findMinMax(TreeNode _root, int[] _minMax) {
        if (_root != null) {
            if (_root.left != null) {
                _minMax[0] = Math.min(_root.left.val, _minMax[0]);
                _minMax[1] = Math.max(_root.left.val, _minMax[1]);
            }
            if (_root.right != null) {
                _minMax[0] = Math.min(_root.right.val, _minMax[0]);
                _minMax[1] = Math.max(_root.right.val, _minMax[1]);
            }
            findMinMax(_root.left, _minMax);
            findMinMax(_root.right, _minMax);
        }
        return _minMax;
    }

}
