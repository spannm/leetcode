package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1506. Find Root of N-Ary Tree.
 */
class Problem1506 extends LeetcodeProblem {

    Node findRoot(List<Node> tree) {
        int x = 0;
        for (Node node : tree) {
            x ^= node.val;
            for (Node child : node.children) {
                x ^= child.val;
            }
        }
        for (int i = 0;; i++) {
            if (tree.get(i).val == x) {
                return tree.get(i);
            }
        }
    }

    static class Node {
        private final int        val;
        private final List<Node> children;

        Node() {
            this(0, null);
        }

        Node(int _val, List<Node> _children) {
            val = _val;
            children = new ArrayList<>();
            if (_children != null) {
                children.addAll(_children);
            }
        }
    }

}
