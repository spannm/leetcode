package io.github.spannm.leetcode.dep;

@SuppressWarnings("checkstyle:VisibilityModifierCheck")
public class PolyNode {
    public int      coefficient;
    public int      power;
    public PolyNode next = null;

    public PolyNode() {
    }

    public PolyNode(int _x, int _y) {
        coefficient = _x;
        power = _y;
    }

    public PolyNode(int _x, int _y, PolyNode _next) {
        coefficient = _x;
        power = _y;
        next = _next;
    }

}
