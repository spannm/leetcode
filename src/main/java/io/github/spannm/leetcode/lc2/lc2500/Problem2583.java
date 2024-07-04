package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

class Problem2583 extends LeetcodeProblem {

    long kthLargestLevelSum(TreeNode _root, int _k) {
        List<Long> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(_root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long thisSum = 0L;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                thisSum += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            list.add(thisSum);
        }
        list.sort(Comparator.reverseOrder());
        return _k > list.size() ? -1 : list.get(_k - 1);
    }

}
