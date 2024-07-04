package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Problem1490 extends LeetcodeProblem {

    Node cloneTree(Node _root) {
        if (_root == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        map.put(_root, new Node(_root.val));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(_root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node child : curr.children) {
                Node childCopy = new Node(child.val);
                if (!map.containsKey(child)) {
                    map.put(child, childCopy);
                    queue.offer(child);
                }
                map.get(curr).children.add(childCopy);
            }
        }
        return map.get(_root);
    }

}
