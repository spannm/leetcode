package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Problem0988 extends LeetcodeProblem {

    String smallestFromLeaf(TreeNode _root) {
        List<String> paths = new ArrayList<>();
        Map<Integer, Character> map = IntStream.rangeClosed(0, 25).boxed().collect(Collectors.toMap(i -> i, v -> (char) (v + 97)));
        dfs(_root, "", paths, map);
        return findSmallest(paths);
    }

    static String findSmallest(List<String> _paths) {
        List<String> reversed = new ArrayList<>();
        for (String path : _paths) {
            StringBuilder sb = new StringBuilder();
            sb.append(path);
            reversed.add(sb.reverse().toString());
        }
        Collections.sort(reversed);
        return reversed.get(0);
    }

    static void dfs(TreeNode _root, String _path, List<String> _paths, Map<Integer, Character> _map) {
        if (_root == null) {
            return;
        }
        _path += _map.get(_root.val);
        if (_root.left == null && _root.right == null) {
            _paths.add(_path);
        }
        dfs(_root.left, _path, _paths, _map);
        dfs(_root.right, _path, _paths, _map);
        _path = _path.substring(0, _path.length() - 1);
    }

}
