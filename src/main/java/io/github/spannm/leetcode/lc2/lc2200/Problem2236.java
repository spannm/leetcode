package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem2236 extends LeetcodeProblem {

    boolean checkTree(TreeNode _root) {
        return _root.val == _root.left.val + _root.right.val;
    }

}
