package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1305 extends LeetcodeProblem {

    List<Integer> getAllElements(TreeNode _root1, TreeNode _root2) {
        List<Integer> list1 = getAllNodes(_root1);
        List<Integer> list2 = getAllNodes(_root2);
        List<Integer> merged = new ArrayList<>();
        merged.addAll(list1);
        merged.addAll(list2);
        Collections.sort(merged);
        return merged;
    }

    private List<Integer> getAllNodes(TreeNode _root) {
        List<Integer> list = new ArrayList<>();
        return inorder(_root, list);
    }

    List<Integer> inorder(TreeNode _root, List<Integer> _result) {
        if (_root == null) {
            return _result;
        }
        inorder(_root.left, _result);
        _result.add(_root.val);
        return inorder(_root.right, _result);
    }

}
