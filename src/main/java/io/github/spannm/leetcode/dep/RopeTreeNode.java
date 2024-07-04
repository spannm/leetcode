package io.github.spannm.leetcode.dep;

@SuppressWarnings("checkstyle:VisibilityModifierCheck")
public class RopeTreeNode {
    public int          len;
    public String       val;
    public RopeTreeNode left;
    public RopeTreeNode right;

    public RopeTreeNode() {
    }

    public RopeTreeNode(String _val) {
        len = 0;
        val = _val;
    }

    public RopeTreeNode(int _len) {
        len = _len;
        val = "";
    }

    public RopeTreeNode(int _len, RopeTreeNode _left, RopeTreeNode _right) {
        len = _len;
        val = "";
        left = _left;
        right = _right;
    }

}
