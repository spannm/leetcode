package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem0094 extends LeetcodeProblem {

    List<Integer> inorderTraversal(TreeNode _root) {
        return inorder(_root, new ArrayList<>());
    }

    static List<Integer> inorder(TreeNode _root, List<Integer> _result) {
        if (_root == null) {
            return _result;
        }
        inorder(_root.left, _result);
        _result.add(_root.val);
        return inorder(_root.right, _result);
    }

}
