package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0572 extends LeetcodeProblem {

    boolean isSubtree(TreeNode _s, TreeNode _t) {
        if (_s == null && _t == null) {
            return true;
        }
        boolean isSubTree = false;
        if (_s != null && _t != null && _s.val == _t.val) {
            isSubTree = isSameTree(_s, _t);
        }
        if (isSubTree) {
            return true;
        }
        boolean isSubTreeLeft = false;
        if (_s.left != null) {
            isSubTreeLeft = isSubtree(_s.left, _t);
        }
        if (isSubTreeLeft) {
            return true;
        }
        boolean isSubTreeRight = false;
        if (_s.right != null) {
            isSubTreeRight = isSubtree(_s.right, _t);
        }
        return isSubTreeRight;
    }

    private static boolean isSameTree(TreeNode _p, TreeNode _q) {
        if (_p == null || _q == null) {
            return _p == _q;
        }
        return _p.val == _q.val && isSameTree(_p.left, _q.left) && isSameTree(_p.right, _q.right);
    }

}
