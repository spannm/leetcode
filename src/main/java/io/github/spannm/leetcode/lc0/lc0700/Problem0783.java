package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/minimum-distance-between-bst-nodes/">783. Minimum Distance Between BST
 * Nodes</a>.
 */
class Problem0783 extends LeetcodeProblem {

    int minDiffInBST(TreeNode _root) {
        java.util.Set<Integer> values = new java.util.TreeSet<>();
        collectValues(_root, values);
        int min = Integer.MAX_VALUE;
        Integer val1 = null;
        for (Integer val2 : values) {
            if (val1 != null) {
                min = Math.min(min, val2 - val1);
            }
            val1 = val2;
        }
        return min;
    }

    static void collectValues(TreeNode _root, java.util.Collection<Integer> _values) {
        if (_root != null) {
            _values.add(_root.val);
            collectValues(_root.left, _values);
            collectValues(_root.right, _values);
        }
    }

}
