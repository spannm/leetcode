package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem1008 extends LeetcodeProblem {
    private int i = 0;

    TreeNode bstFromPreorder(int[] _preorder) {
        return bstFromPreorder(_preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] _preorder, int _bound) {
        if (i == _preorder.length || _preorder[i] > _bound) {
            return null;
        }
        TreeNode root = new TreeNode(_preorder[i++]);
        root.left = bstFromPreorder(_preorder, root.val);
        root.right = bstFromPreorder(_preorder, _bound);
        return root;
    }

}
