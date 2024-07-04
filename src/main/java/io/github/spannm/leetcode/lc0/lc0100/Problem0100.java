package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/same-tree/">100. Same Tree</a>.
 */
class Problem0100 extends LeetcodeProblem {

    boolean isSameTree(TreeNode _p, TreeNode _q) {
        if (_p == null && _q == null) {
            return true;
        } else if (_p == null || _q == null) {
            return false;
        } else if (_p == _q) {
            return true;
        }
        return Objects.equals(_p.val, _q.val)
            && isSameTree(_p.left, _q.left)
            && isSameTree(_p.right, _q.right);
    }

}
