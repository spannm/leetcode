package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem0872 extends LeetcodeProblem {

    boolean leafSimilar(TreeNode _root1, TreeNode _root2) {
        return preorder(_root1, new ArrayList<>())
            .equals(preorder(_root2, new ArrayList<>()));
    }

    static List<Integer> preorder(TreeNode _root, List<Integer> _leaves) {
        if (_root != null) {
            if (_root.left == null && _root.right == null) {
                _leaves.add(_root.val);
            }
            preorder(_root.left, _leaves);
            preorder(_root.right, _leaves);
        }
        return _leaves;
    }

}
