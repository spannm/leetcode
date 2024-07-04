package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 156. Binary Tree Upside Down
 * <p>
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same
 * parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left
 * leaf nodes. Return the new root.
 * <p>
 * For example: Given a binary tree {1,2,3,4,5}, 1 / \ 2 3 / \ 4 5
 * <p>
 * return the root of the binary tree [4,5,2,#,#,3,1]. 4 / \ 5 2 / \ 3 1
 * <p>
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
class Problem0156 extends LeetcodeProblem {

    TreeNode upsideDownBinaryTree(TreeNode _root) {
        if (_root == null || _root.left == null && _root.right == null) {
            return _root;
        }
        TreeNode newRoot = upsideDownBinaryTree(_root.left);
        _root.left.left = _root.right;
        _root.left.right = _root;
        _root.left = null;
        _root.right = null;
        return newRoot;
    }

}
