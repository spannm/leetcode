package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

class Problem0314 extends LeetcodeProblem {

    List<List<Integer>> verticalOrder(TreeNode _root) {
        if (_root == null) {
            return List.of();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> bfsQ = new LinkedList<>();
        Queue<Integer> idxQ = new LinkedList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        bfsQ.offer(_root);
        idxQ.offer(0);
        while (!bfsQ.isEmpty()) {
            int qSize = bfsQ.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = bfsQ.poll();
                int index = idxQ.poll();
                if (map.containsKey(index)) {
                    map.get(index).add(curr.val);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr.val);
                    map.put(index, list);
                }
                if (curr.left != null) {
                    bfsQ.offer(curr.left);
                    idxQ.offer(index - 1);
                }
                if (curr.right != null) {
                    bfsQ.offer(curr.right);
                    idxQ.offer(index + 1);
                }
            }
        }
        for (int i : map.keySet()) {
            result.add(map.get(i));
        }
        return result;
    }

}
