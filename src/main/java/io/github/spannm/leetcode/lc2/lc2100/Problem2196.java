package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2196. Create Binary Tree From Descriptions.
 */
class Problem2196 extends LeetcodeProblem {

    TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> m = new HashMap<>();
        Set<Integer> vis = new HashSet<>();
        for (int[] d : descriptions) {
            int p = d[0];
            int c = d[1];
            int isLeft = d[2];
            if (!m.containsKey(p)) {
                m.put(p, new TreeNode(p));
            }
            if (!m.containsKey(c)) {
                m.put(c, new TreeNode(c));
            }
            if (isLeft == 1) {
                m.get(p).left = m.get(c);
            } else {
                m.get(p).right = m.get(c);
            }
            vis.add(c);
        }
        for (Map.Entry<Integer, TreeNode> entry : m.entrySet()) {
            if (!vis.contains(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

}
