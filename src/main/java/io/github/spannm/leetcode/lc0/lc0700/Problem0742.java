package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

class Problem0742 extends LeetcodeProblem {

    int findClosestLeaf(TreeNode _root, int _k) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();
        buildGraph(_root, graph, null, leaves);
        if (leaves.contains(_k)) {
            return _k;
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> directNeighbors = graph.get(_k);
        Set<Integer> visited = new HashSet<>();
        visited.add(_k);
        for (int node : directNeighbors) {
            queue.offer(node);
            visited.add(node);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (leaves.contains(curr)) {
                    return curr;
                }
                Set<Integer> nextNodes = graph.get(curr);
                for (int next : nextNodes) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return _root.val;
    }

    private void buildGraph(TreeNode _root, Map<Integer, Set<Integer>> _map, TreeNode _parent, Set<Integer> _leaves) {
        if (_root == null) {
            return;
        }
        if (!_map.containsKey(_root.val)) {
            _map.put(_root.val, new HashSet<>());
        }
        if (_root.left != null) {
            _map.get(_root.val).add(_root.left.val);
        }
        if (_root.right != null) {
            _map.get(_root.val).add(_root.right.val);
        }
        if (_parent != null) {
            _map.get(_root.val).add(_parent.val);
        }
        if (_root.left == null && _root.right == null) {
            _leaves.add(_root.val);
        }
        buildGraph(_root.left, _map, _root, _leaves);
        buildGraph(_root.right, _map, _root, _leaves);
    }

}
