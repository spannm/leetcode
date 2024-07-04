package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/">863. All Nodes Distance K in Binary
 * Tree</a>.
 */
class Problem0863 extends LeetcodeProblem {

    List<Integer> distanceK(final TreeNode _root, final TreeNode _target, int _k) {
        final List<Integer> answer = new ArrayList<>();
        final Map<Integer, TreeNode> parent = new HashMap<>();
        final Queue<TreeNode> q = new LinkedList<>();
        q.offer(_root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = q.poll();

                Optional.ofNullable(top.left).ifPresent(n -> {
                    parent.put(n.val, top);
                    q.offer(n);
                });

                Optional.ofNullable(top.right).ifPresent(n -> {
                    parent.put(n.val, top);
                    q.offer(n);
                });
            }
        }

        Map<Integer, Integer> visited = new HashMap<>();
        q.offer(_target);

        while (_k > 0 && !q.isEmpty()) {
            final int sz = q.size();

            for (int i = 0; i < sz; i++) {
                TreeNode top = q.poll();

                visited.put(top.val, 1);

                if (top.left != null && !visited.containsKey(top.left.val)) {
                    q.offer(top.left);
                }

                if (top.right != null && !visited.containsKey(top.right.val)) {
                    q.offer(top.right);
                }

                if (parent.containsKey(top.val) && !visited.containsKey(parent.get(top.val).val)) {
                    q.offer(parent.get(top.val));
                }
            }

            _k--;
        }

        while (!q.isEmpty()) {
            answer.add(q.poll().val);
        }
        return answer;
    }

}
