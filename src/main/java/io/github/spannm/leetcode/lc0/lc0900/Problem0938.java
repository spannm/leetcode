package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem0938 extends LeetcodeProblem {

    int rangeSumBST(TreeNode _root, int _low, int _high) {
        return _root == null ? 0 : dfs(_root, _low, _high, new ArrayList<>()).stream().mapToInt(num -> num).sum();
    }

    static List<Integer> dfs(TreeNode _root, int _l, int _r, List<Integer> _list) {
        if (_root != null) {
            if (_root.val <= _r && _root.val >= _l) {
                _list.add(_root.val);
            }
            dfs(_root.left, _l, _r, _list);
            dfs(_root.right, _l, _r, _list);
        }
        return _list;
    }

}
