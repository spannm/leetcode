package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem2265 extends LeetcodeProblem {

    int averageOfSubtree(TreeNode _root) {
        // 0 position has sum, 1 position has total nodes
        int[] ans = new int[2];
        solve(_root, ans);
        return ans[0];
    }

    static int[] solve(TreeNode _node, int[] _ans) {
        if (_node == null) {
            return new int[] {0, 0};
        }

        int[] left = solve(_node.left, _ans);
        int[] right = solve(_node.right, _ans);

        int tot = 1 + left[1] + right[1];

        int avg = (_node.val + left[0] + right[0]) / tot;
        if (avg == _node.val) {
            _ans[0]++;
        }

        return new int[] {_node.val + left[0] + right[0], tot};
    }

}
