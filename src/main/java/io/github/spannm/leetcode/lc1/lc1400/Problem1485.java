package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1485 extends LeetcodeProblem {

    NodeCopy copyRandomBinaryTree(Node _root) {
        if (_root == null) {
            return null;
        }
        Map<Node, NodeCopy> map = new HashMap<>();
        map.put(_root, new NodeCopy(_root.val));
        dfs(_root, map);
        dfsConnect(_root, map);
        return map.get(_root);
    }

    private static void dfsConnect(Node _root, Map<Node, NodeCopy> _map) {
        if (_root == null) {
            return;
        }
        NodeCopy copy = _map.get(_root);
        if (_root.left != null) {
            copy.left = _map.get(_root.left);
        }
        if (_root.right != null) {
            copy.right = _map.get(_root.right);
        }
        if (_root.random != null) {
            copy.random = _map.get(_root.random);
        }
        _map.put(_root, copy);
        dfsConnect(_root.left, _map);
        dfsConnect(_root.right, _map);
    }

    private static void dfs(Node _root, Map<Node, NodeCopy> _map) {
        if (_root == null) {
            return;
        }
        NodeCopy copy = _map.getOrDefault(_root, new NodeCopy(_root.val));
        if (_root.left != null) {
            copy.left = new NodeCopy(_root.left.val);
        }
        if (_root.right != null) {
            copy.right = new NodeCopy(_root.right.val);
        }
        if (_root.random != null) {
            copy.random = new NodeCopy(_root.random.val);
        }
        _map.put(_root, copy);
        dfs(_root.left, _map);
        dfs(_root.right, _map);
    }

    @SuppressWarnings("checkstyle:VisibilityModifierCheck")
    static class Node {
        int         val;
        Node left;
        Node right;
        Node random;

        Node() {
        }

        Node(int _val) {
            val = _val;
        }

        Node(int _val, Node _left, Node _right, Node _random) {
            val = _val;
            left = _left;
            right = _right;
            random = _random;
        }
    }

    @SuppressWarnings("checkstyle:VisibilityModifierCheck")
    static class NodeCopy {
        int      val;
        NodeCopy left;
        NodeCopy right;
        NodeCopy random;

        NodeCopy() {
        }

        NodeCopy(int _val) {
            val = _val;
        }

        NodeCopy(int _val, NodeCopy _left, NodeCopy _right, NodeCopy _random) {
            val = _val;
            left = _left;
            right = _right;
            random = _random;
        }
    }

}
