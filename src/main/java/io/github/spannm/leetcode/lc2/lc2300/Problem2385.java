package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

/**
 * 2385. Amount of Time for Binary Tree to Be Infected.
 */
class Problem2385 extends LeetcodeProblem {

    int amountOfTime(TreeNode _root, int _start) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        dfs(_root, g);
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> vis = new HashSet<>();
        q.offer(_start);
        int ans = -1;
        while (!q.isEmpty()) {
            ans++;
            for (int n = q.size(); n > 0; n--) {
                int i = q.pollFirst();
                vis.add(i);
                if (g.containsKey(i)) {
                    for (int j : g.get(i)) {
                        if (!vis.contains(j)) {
                            q.offer(j);
                        }
                    }
                }
            }
        }
        g = null;
        return ans;
    }

    static void dfs(TreeNode _root, Map<Integer, List<Integer>> _g) {
        if (_root == null) {
            return;
        }
        if (_root.left != null) {
            _g.computeIfAbsent(_root.val, k -> new ArrayList<>()).add(_root.left.val);
            _g.computeIfAbsent(_root.left.val, k -> new ArrayList<>()).add(_root.val);
        }
        if (_root.right != null) {
            _g.computeIfAbsent(_root.val, k -> new ArrayList<>()).add(_root.right.val);
            _g.computeIfAbsent(_root.right.val, k -> new ArrayList<>()).add(_root.val);
        }
        dfs(_root.left, _g);
        dfs(_root.right, _g);
    }

}
