package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">111. Minimum Depth of Binary Tree</a>.
 */
class Problem0111 extends LeetcodeProblem {

    static int minDepth(final TreeNode _node) {
        if (_node == null) {
            return 0;
        }

        int lc = minDepth(_node.left);
        int rc = minDepth(_node.right);

        int rtn = 1;
        if (lc != 0 && rc != 0) {
            rtn += Math.min(lc, rc);
        } else if (lc != 0) {
            rtn += lc;
        } else if (rc != 0) {
            rtn += rc;
        }
        return rtn;
    }

}
