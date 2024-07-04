package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/clone-graph/">133. Clone Graph</a>.
 */
class Problem0133 extends LeetcodeProblem {

    Node cloneGraph(Node _node) {
        return cloneGraphBfs(_node);
        // return cloneGraphDfs(_node, new HashMap<>());
    }

    Node cloneGraphBfs(Node _node) {
        if (_node == null) {
            return null;
        }

        final Map<Node, Node> mp = new HashMap<>();
        Node clone = new Node(_node.val);
        mp.put(_node, clone);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(_node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node val : cur.neighbors) {
                if (!mp.containsKey(val)) {
                    mp.put(val, new Node(val.val));
                    queue.offer(val);
                }
                mp.get(cur).neighbors.add(mp.get(val));
            }
        }
        return clone;
    }

    static Node cloneGraphDfs(final Node _node, final Map<Node, Node> _dfsMap) {
        if (_node == null) {
            return null;
        }

        Node existing = _dfsMap.get(_node);
        if (existing != null) {
            return existing;
        }

        _dfsMap.put(_node, new Node(_node.val));
        for (Node val : _node.neighbors) {
            _dfsMap.get(_node).neighbors.add(cloneGraphDfs(val, _dfsMap));
        }

        return _dfsMap.get(_node);
    }

}
