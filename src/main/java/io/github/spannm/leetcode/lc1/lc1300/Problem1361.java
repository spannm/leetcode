package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/validate-binary-tree-nodes/">1361. Validate Binary Tree Nodes</a>.
 */
class Problem1361 extends LeetcodeProblem {

    boolean validateBinaryTreeNodes(int _n, int[] _leftChild, int[] _rightChild) {
        int[] parents = new int[_n];
        int root = -1;
        for (int i = 0; i < _n; i++) {
            if (_leftChild[i] != -1) {
                parents[_leftChild[i]]++;
            }
            if (_rightChild[i] != -1) {
                parents[_rightChild[i]]++;
            }
        }
        for (int i = 0; i < _n; i++) {
            if (parents[i] > 1 || parents[i] == 0 && root != -1) {
                return false;
            } else if (parents[i] == 0) {
                root = i;
            }
        }
        return _n == dfs(root, _leftChild, _rightChild, new boolean[_n]);
    }

    static int dfs(int _start, int[] _leftChild, int[] _rightChild, boolean[] _visited) {
        if (_start == -1) {
            return 0;
        }
        _visited[_start] = true;
        if (_leftChild[_start] != -1 && _visited[_leftChild[_start]]
            || _rightChild[_start] != -1 && _visited[_rightChild[_start]]) {
            return 1000000;
        }
        return 1
            + dfs(_leftChild[_start], _leftChild, _rightChild, _visited)
            + dfs(_rightChild[_start], _leftChild, _rightChild, _visited);
    }

}
