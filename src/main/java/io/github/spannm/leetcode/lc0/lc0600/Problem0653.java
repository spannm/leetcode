package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem0653 extends LeetcodeProblem {

    boolean findTarget(TreeNode _root, int _k) {
        if (_root == null) {
            return false;
        }

        List<Integer> list = dfs(_root, new ArrayList<>());

        int sz = list.size();
        for (int i = 0; i < sz - 1; i++) {
            for (int j = i + 1; j < sz; j++) {
                if (list.get(i) + list.get(j) == _k) {
                    return true;
                }
            }
        }
        return false;
    }

    static List<Integer> dfs(TreeNode _root, List<Integer> _list) {
        _list.add(_root.val);
        if (_root.left != null) {
            dfs(_root.left, _list);
        }
        if (_root.right != null) {
            dfs(_root.right, _list);
        }
        return _list;
    }

}
