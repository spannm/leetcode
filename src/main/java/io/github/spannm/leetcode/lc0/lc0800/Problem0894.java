package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/all-possible-full-binary-trees/">894. All Possible Full Binary Trees</a>.
 */
class Problem0894 extends LeetcodeProblem {

    List<TreeNode> allPossibleFBT(int _n) {
        if (_n % 2 == 0) {
            return List.of();
        }
        _n--;
        if (_n == 0) {
            return List.of(new TreeNode(0));
        }

        final List<TreeNode> result = new ArrayList<>();
        for (int i = 1; i < _n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(_n - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    result.add(new TreeNode(0, l, r));
                }
            }
        }
        return result;
    }

}
