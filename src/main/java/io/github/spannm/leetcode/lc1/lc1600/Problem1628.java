package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Problem1628 extends LeetcodeProblem {

    @SuppressWarnings("checkstyle:VisibilityModifierCheck")
    abstract static class Node {
        Node   left;
        Node   right;
        String val;

        public abstract int evaluate();

        public abstract List<String> print(Node _node, List<String> _list);
    }

    static class NodeImpl extends Node {

        NodeImpl(String _val) {
            val = _val;
        }

        @Override
        public int evaluate() {
            return dfs(this);
        }

        private int dfs(Node _node) {
            if (_node == null) {
                return 0;
            } else if (_node.left == null && _node.right == null) {
                return Integer.parseInt(_node.val);
            }
            String op = _node.val;
            int left = dfs(_node.left);
            int right = dfs(_node.right);
            return switch (op) {
                case "+" -> left + right;
                case "-" -> left - right;
                case "*" -> left * right;
                default -> left / right;
            };
        }

        @Override
        public List<String> print(Node _node, List<String> _list) {
            if (_node == null) {
                return _list;
            }
            print(_node.left, _list);
            _list.add(_node.val);
            print(_node.right, _list);
            return _list;
        }

    }

    static class TreeBuilder {
        public Node buildTree(String[] _postfix) {
            Deque<Node> stack = new LinkedList<>();
            for (String str : _postfix) {
                Node node = new NodeImpl(str);
                if (!Character.isDigit(str.charAt(0))) {
                    node.right = stack.pollLast();
                    node.left = stack.pollLast();
                }
                stack.addLast(node);
            }
            return stack.pop();
        }

    }

}
