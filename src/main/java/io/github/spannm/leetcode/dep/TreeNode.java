package io.github.spannm.leetcode.dep;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
@SuppressWarnings("checkstyle:VisibilityModifierCheck")
public class TreeNode {
    public int      val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int _val) {
        this(_val, null, null);
    }

    public TreeNode(int _val, TreeNode _left, TreeNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    /**
     * Constructs a normal binary tree. The input reads like
     * this for [5, 3, 6, 2, 4, null, null, 1], i.e. preorder:
     * <pre>
     *            5
     *          /   \
     *         3     6
     *        / \    / \
     *       2   4  #   #
     *      /
     *     1
     * </pre>
     * @param _values value
     * @return root node
     */
    public static TreeNode createTree(List<Integer> _values) {
        if (_values.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(_values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < _values.size(); i++) {
            TreeNode curr = queue.poll();
            if (_values.get(i) != null) {
                curr.left = new TreeNode(_values.get(i));
                queue.offer(curr.left);
            }
            if (++i < _values.size() && _values.get(i) != null) {
                curr.right = new TreeNode(_values.get(i));
                queue.offer(curr.right);
            }
        }
        return root;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public boolean equals(Object _obj) {
        if (this == _obj) {
            return true;
        } else if (_obj == null || getClass() != _obj.getClass()) {
            return false;
        }
        TreeNode other = (TreeNode) _obj;

        return val == other.val
            && Objects.equals(left, other.left)
            && Objects.equals(right, other.right);
    }

    @Override
    public String toString() {
        return String.format("%s[val=%s, l=%s, r=%s]", getClass().getSimpleName(), val, left, right);
    }

    public String toValString() {
        return val
            + "," + (left == null ? "null" : left.toValString())
            + "," + (right == null ? "null" : right.toValString());
    }

    /**
     * The in-order traversal consists of first visiting the left sub-tree, then the root node, and finally the right
     * sub-tree.
     */
    public static void printInOrder(TreeNode _node) {
        if (_node != null) {
            printInOrder(_node.left);
            System.out.print(" " + _node.val);
            printInOrder(_node.right);
        }
    }

    /**
     * Pre-order traversal visits first the root node, then the left sub-tree, and finally the right sub-tree.
     */
    public static void printPreOrder(TreeNode _node) {
        if (_node != null) {
            System.out.print(" " + _node.val);
            printPreOrder(_node.left);
            printPreOrder(_node.right);
        }
    }

    /**
     * Post-order traversal visits the left sub-tree, the right subt-ree, and the root node at the end.
     */
    public static void printPostOrder(TreeNode _node) {
        if (_node != null) {
            printPreOrder(_node.left);
            printPreOrder(_node.right);
            System.out.print(" " + _node.val);
        }
    }

}
