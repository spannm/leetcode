package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem1609 extends LeetcodeProblem {

    boolean isEvenOddTree(TreeNode _root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(_root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (level % 2 == 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) % 2 == 0 || i < list.size() - 1 && list.get(i) >= list.get(i + 1)) {
                        return false;
                    }
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) % 2 != 0 || i < list.size() - 1 && list.get(i) <= list.get(i + 1)) {
                        return false;
                    }
                }
            }
            level++;
        }
        return true;
    }

}
