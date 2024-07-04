package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem1038 extends LeetcodeProblem {
    private int greaterSum = 0;

    TreeNode bstToGst(TreeNode _root) {
        if (_root.right != null) {
            bstToGst(_root.right);
        }
        greaterSum = _root.val = greaterSum + _root.val;
        if (_root.left != null) {
            bstToGst(_root.left);
        }
        return _root;
    }

}
