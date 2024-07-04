package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">95. Unique Binary Search Trees II</a>.
 */
class Problem0095 extends LeetcodeProblem {

    List<TreeNode> generateTrees(final int _totalNodes) {
        List<TreeNode> result = generateTrees(1, _totalNodes);
        System.gc();
        return result;
    }

    private static List<TreeNode> generateTrees(final int _val, final int _totalNodes) {
        List<TreeNode> result = new ArrayList<>();
        if (_val > _totalNodes) {
            result.add(null);
            return result;
        }

        for (int i = _val; i <= _totalNodes; i++) {
            // so here when root is `i` we get an array of all roots of all possible left subtree
            List<TreeNode> left = generateTrees(_val, i - 1);
            // so here when root is `i` we get an array of all roots of all possible right subtree
            List<TreeNode> right = generateTrees(i + 1, _totalNodes);

            // since we have all possible roots from left and right we now make all possible combo of it
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode t = new TreeNode(i, l, r);
                    result.add(t);
                }
            }
        }
        return result;
    }

}
