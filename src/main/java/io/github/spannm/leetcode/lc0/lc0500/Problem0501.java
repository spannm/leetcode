package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

class Problem0501 extends LeetcodeProblem {

    int[] findMode(TreeNode _root) {
        return _root == null
            ? new int[0]
            : bfs(_root, new HashMap<>()).stream().mapToInt(i -> i).toArray();
    }

    static List<Integer> bfs(TreeNode _root, Map<Integer, Integer> _map) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(_root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                Optional.ofNullable(tn.left).ifPresent(queue::offer);
                Optional.ofNullable(tn.right).ifPresent(queue::offer);
                _map.compute(tn.val, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        int highestFrequency = 0;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : _map.entrySet()) {
            if (entry.getValue() > highestFrequency) {
                highestFrequency = entry.getValue();
                list.clear();
                list.add(entry.getKey());
            } else if (entry.getValue() == highestFrequency) {
                list.add(entry.getKey());
            }
        }

        return list;
    }

}
