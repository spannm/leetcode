package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/">1161. Maximum Level Sum of a Binary
 * Tree</a>.
 */
class Problem1161 extends LeetcodeProblem {

    static int maxLevelSum(final TreeNode _root) {
        if (_root == null) {
            return 0;
        }

        final Queue<TreeNode> q = new LinkedList<>();
        q.add(_root);

        int lvl = 0;
        int minLvl = 0;
        int maxSum = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            lvl++;
            int lvlSum = 0;
            final int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                TreeNode node = q.poll();
                lvlSum += node.val;
                Optional.ofNullable(node.left).ifPresent(q::add);
                Optional.ofNullable(node.right).ifPresent(q::add);
            }
            if (lvlSum > maxSum) {
                maxSum = lvlSum;
                minLvl = lvl;
            }
        }
        return minLvl;
    }

}
