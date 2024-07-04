package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0449 extends LeetcodeProblem {

    String serialize(TreeNode _root) {
        return _root == null ? null : serialize(_root, new StringBuilder());
    }

    private static String serialize(TreeNode _root, StringBuilder _sb) {
        if (_root == null) {
            return null;
        }
        _sb.append(_root.val).append(" ");
        serialize(_root.left, _sb);
        serialize(_root.right, _sb);
        return _sb.toString();
    }

    TreeNode deserialize(String _data) {
        if (_data == null || _data.isEmpty()) {
            return null;
        }
        String[] values = _data.split(" ");
        int[] index = new int[] {0};
        return deserialize(values, index, Integer.MAX_VALUE);
    }

    private static TreeNode deserialize(String[] _values, int[] _index, int _maxValue) {
        if (_index[0] >= _values.length || Integer.parseInt(_values[_index[0]]) >= _maxValue) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(_values[_index[0]++]));
        root.left = deserialize(_values, _index, root.val);
        root.right = deserialize(_values, _index, _maxValue);
        return root;
    }

}
