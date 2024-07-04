package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2764. is Array a Preorder of Some ‌Binary Tree.
 */
class Problem2764 extends LeetcodeProblem {

    private List<List<Integer>>               nodes;
    private final Map<Integer, List<Integer>> g = new HashMap<>();
    private int                               k;

    boolean isPreorder(List<List<Integer>> _nodes) {
        nodes = _nodes;
        for (var node : _nodes) {
            g.computeIfAbsent(node.get(1), key -> new ArrayList<>()).add(node.get(0));
        }
        return dfs(_nodes.get(0).get(0)) && k == _nodes.size();
    }

    private boolean dfs(int i) {
        if (i != nodes.get(k).get(0)) {
            return false;
        }
        k++;
        for (int j : g.getOrDefault(i, List.of())) {
            if (!dfs(j)) {
                return false;
            }
        }
        return true;
    }

}
