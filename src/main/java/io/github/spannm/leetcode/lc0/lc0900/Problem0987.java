package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

class Problem0987 extends LeetcodeProblem {

    List<List<Integer>> verticalTraversal(TreeNode _root) {
        Map<Integer, Map<Integer, Queue<Integer>>> map = new TreeMap<>();
        dfs(_root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (Map<Integer, Queue<Integer>> yMap : map.values()) {
            list.add(new ArrayList<>());
            for (Queue<Integer> nodes : yMap.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    private static void dfs(TreeNode _root, int _x, int _y, Map<Integer, Map<Integer, Queue<Integer>>> _map) {
        if (_root != null) {
            _map.computeIfAbsent(_x, k -> new TreeMap<>())
                .computeIfAbsent(_y, k -> new PriorityQueue<>())
                .offer(_root.val);
            dfs(_root.left, _x - 1, _y + 1, _map);
            dfs(_root.right, _x + 1, _y + 1, _map);
        }
    }

}
