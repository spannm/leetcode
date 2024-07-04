package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Problem0655 extends LeetcodeProblem {

    List<List<String>> printTree(TreeNode _root) {
        List<List<String>> result = new LinkedList<>();
        int height = _root == null ? 1 : getHeight(_root);
        int rows = height;
        int columns = (int) (Math.pow(2, height) - 1);
        List<String> row = new ArrayList<>();
        for (int i = 0; i < columns; i++) {
            row.add("");
        }
        for (int i = 0; i < rows; i++) {
            result.add(new ArrayList<>(row));
        }
        populateResult(_root, result, 0, rows, 0, columns - 1);
        return result;
    }

    static void populateResult(TreeNode _root, List<List<String>> _result, int _row, int _totalRows, int _i, int _j) {
        if (_row == _totalRows || _root == null) {
            return;
        }
        _result.get(_row).set((_i + _j) / 2, Integer.toString(_root.val));
        populateResult(_root.left, _result, _row + 1, _totalRows, _i, (_i + _j) / 2 - 1);
        populateResult(_root.right, _result, _row + 1, _totalRows, (_i + _j) / 2 + 1, _j);
    }

    static int getHeight(TreeNode _root) {
        return _root == null ? 0 : 1 + Math.max(getHeight(_root.left), getHeight(_root.right));
    }

}
