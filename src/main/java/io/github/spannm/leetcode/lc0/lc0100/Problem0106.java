package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106. Construct
 * Binary Tree from Inorder and Postorder Traversal</a>.
 */
class Problem0106 extends LeetcodeProblem {

    TreeNode buildTree(int[] _inorder, int[] _postorder) {
        return buildTreeRecurse(_inorder, 0, _inorder.length - 1, _postorder, 0, _postorder.length - 1);
    }

    static TreeNode buildTreeRecurse(int[] _inOrder, int _inStart, int _inEnd,
        int[] _postOrder, int _postStart, int _postEnd) {
        if (_inStart > _inEnd || _postStart > _postEnd) {
            return null;
        }

        final int rootVal = _postOrder[_postEnd];

        int rootIndex = IntStream.rangeClosed(_inStart, _inEnd)
            .filter(i -> _inOrder[i] == rootVal)
            .findFirst().orElse(0);

        final int leftSz = rootIndex - _inStart;
        final int rightSz = _inEnd - rootIndex;

        return new TreeNode(rootVal,
            buildTreeRecurse(_inOrder, _inStart, rootIndex - 1,
                _postOrder, _postStart, _postStart + leftSz - 1),
            buildTreeRecurse(_inOrder, rootIndex + 1, _inEnd,
                _postOrder, _postEnd - rightSz, _postEnd - 1));
    }

}
