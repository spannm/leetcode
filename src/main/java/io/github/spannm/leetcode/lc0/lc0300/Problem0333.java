package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0333 extends LeetcodeProblem {
    private int max = 0;

    int largestBSTSubtree(TreeNode _root) {
        if (_root == null) {
            return 0;
        }
        traverse(_root);
        return max;
    }

    Result traverse(TreeNode _root) {
        if (_root == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Result left = traverse(_root.left);
        Result right = traverse(_root.right);
        if (left.size == -1 || right.size == -1 || _root.val <= left.upper || _root.val >= right.lower) {
            return new Result(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        max = Math.max(size, max);
        return new Result(size, Math.min(left.lower, _root.val), Math.max(right.upper, _root.val));
    }

    static class Result {
        private final int size;
        private final int lower;
        private final int upper;

        Result(int _size, int _lower, int _upper) {
            size = _size;
            lower = _lower;
            upper = _upper;
        }
    }

}
