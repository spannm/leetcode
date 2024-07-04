package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 2415. Reverse Odd Levels of Binary Tree.
 */
class Problem2415 extends LeetcodeProblem {

    TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        for (int i = 0; !q.isEmpty(); i++) {
            List<TreeNode> t = new ArrayList<>();
            for (int k = q.size(); k > 0; k--) {
                var node = q.poll();
                if (i % 2 == 1) {
                    t.add(node);
                }
                if (node.left != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            for (int l = 0, r = t.size() - 1; l < r; l++, r--) {
                var x = t.get(l).val;
                t.get(l).val = t.get(r).val;
                t.get(r).val = x;
            }
        }
        return root;
    }

}
