package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem0429 extends LeetcodeProblem {

    List<List<Integer>> levelOrder(Node _root) {
        if (_root == null) {
            return List.of();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(_root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node currentNode = q.poll();
                if (currentNode != null) {
                    level.add(currentNode.val);
                    for (Node child : currentNode.children) {
                        q.offer(child);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }

}
