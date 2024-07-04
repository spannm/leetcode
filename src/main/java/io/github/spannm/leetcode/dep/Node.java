package io.github.spannm.leetcode.dep;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("checkstyle:VisibilityModifierCheck")
public class Node {

    public final int        val;
    public final List<Node> neighbors = new ArrayList<>();
    public final List<Node> children  = new ArrayList<>();

    public Node() {
        val = 0;
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors.addAll(_neighbors);
        children.addAll(_neighbors);
    }

    @Override
    public String toString() {
        return String.format("%s[val=%s, neighbors=%s]",
            getClass().getSimpleName(), val, neighbors.size());
    }

}
