package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">129. Sum Root to Leaf Numbers</a>.
 */
class Problem0129 extends LeetcodeProblem {

    int sumNumbers(TreeNode _root) {
        return sumNumbers(_root, "");
    }

    static int sumNumbers(TreeNode _node, String _numbers) {
        _numbers += _node.val;

        if (_node.left == null && _node.right == null) { // leaf node?
            return Integer.parseInt(_numbers);
        }

        return (_node.left == null ? 0 : sumNumbers(_node.left, _numbers))
            + (_node.right == null ? 0 : sumNumbers(_node.right, _numbers));
    }

}
