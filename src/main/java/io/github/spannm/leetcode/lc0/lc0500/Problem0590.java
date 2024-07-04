package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Node;

import java.util.ArrayList;
import java.util.List;

class Problem0590 extends LeetcodeProblem {

    List<Integer> postorder(Node _root) {
        if (_root == null) {
            return List.of();
        }
        List<Integer> result = new ArrayList<>();
        dfs(_root, result);
        result.add(_root.val);
        return result;
    }

    static void dfs(Node _root, List<Integer> _result) {
        if (_root == null) {
            return;
        }
        if (!_root.children.isEmpty()) {
            for (Node child : _root.children) {
                dfs(child, _result);
                _result.add(child.val);
            }
        }
    }

}
