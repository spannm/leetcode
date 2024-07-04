package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem1379 extends LeetcodeProblem {

    final TreeNode getTargetCopy(TreeNode _orig, TreeNode _cloned, TreeNode _target) {
        if (_orig == null) {
            return null;
        } else if (_orig.val == _target.val) {
            return _cloned;
        }
        TreeNode left = getTargetCopy(_orig.left, _cloned.left, _target);
        if (left != null && left.val == _target.val) {
            return left;
        }
        return getTargetCopy(_orig.right, _cloned.right, _target);
    }

}
