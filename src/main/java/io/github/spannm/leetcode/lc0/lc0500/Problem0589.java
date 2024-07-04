package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Node;

import java.util.ArrayList;
import java.util.List;

class Problem0589 extends LeetcodeProblem {

    List<Integer> preorder(Node _root) {
        return _root == null ? List.of() : dfs(_root, new ArrayList<>());
    }

    static List<Integer> dfs(Node _root, List<Integer> _result) {
        if (_root != null) {
            _result.add(_root.val);
            if (!_root.children.isEmpty()) {
                for (Node child : _root.children) {
                    dfs(child, _result);
                }
            }
        }
        return _result;
    }

}
