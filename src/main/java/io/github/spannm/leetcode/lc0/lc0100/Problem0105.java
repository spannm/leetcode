package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105. Construct
 * Binary Tree from Preorder and Inorder Traversal</a>.
 */
class Problem0105 extends LeetcodeProblem {

    TreeNode buildTree(int[] _preorder, final int[] _inorder) {
        Map<Integer, Integer> inorderMap = IntStream.range(0, _inorder.length).boxed().collect(Collectors.toMap(i -> _inorder[i], i -> i));
        TreeNode result = buildTree(_preorder, 0, _preorder.length - 1, inorderMap, 0, _inorder.length - 1);
        _preorder = null;
        inorderMap = null;
        return result;
    }

    private static TreeNode buildTree(int[] _preorder, int _preStart, int _preEnd, Map<Integer, Integer> _inorderMap, int _inStart, int _inEnd) {
        if (_preStart > _preEnd || _inStart > _inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(_preorder[_preStart]);
        int inRoot = _inorderMap.get(_preorder[_preStart]);

        int numsLeft = inRoot - _inStart;

        root.left = buildTree(_preorder, _preStart + 1, _preStart + numsLeft, _inorderMap, _inStart, inRoot - 1);
        root.right = buildTree(_preorder, _preStart + numsLeft + 1, _preEnd, _inorderMap, inRoot + 1, _inEnd);
        return root;
    }

}
