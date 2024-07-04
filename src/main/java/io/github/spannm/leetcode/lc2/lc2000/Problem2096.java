package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

/**
 * 2096. Step-By-Step Directions From a Binary Tree Node to Another.
 */
class Problem2096 extends LeetcodeProblem {

    private Map<Integer, List<List<String>>> edges;
    private Set<Integer>                     visited;
    private String                           ans;

    String getDirections(TreeNode root, int startValue, int destValue) {
        edges = new HashMap<>();
        visited = new HashSet<>();
        ans = null;
        traverse(root);
        dfs(startValue, destValue, new ArrayList<>());
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            edges.computeIfAbsent(root.val, k -> new ArrayList<>())
                .add(Arrays.asList(String.valueOf(root.left.val), "L"));
            edges.computeIfAbsent(root.left.val, k -> new ArrayList<>())
                .add(Arrays.asList(String.valueOf(root.val), "U"));
        }
        if (root.right != null) {
            edges.computeIfAbsent(root.val, k -> new ArrayList<>())
                .add(Arrays.asList(String.valueOf(root.right.val), "R"));
            edges.computeIfAbsent(root.right.val, k -> new ArrayList<>())
                .add(Arrays.asList(String.valueOf(root.val), "U"));
        }
        traverse(root.left);
        traverse(root.right);
    }

    private void dfs(int start, int dest, List<String> t) {
        if (visited.contains(start)) {
            return;
        }
        if (start == dest) {
            if (ans == null || ans.length() > t.size()) {
                ans = String.join("", t);
            }
            return;
        }
        visited.add(start);
        if (edges.containsKey(start)) {
            for (List<String> item : edges.get(start)) {
                t.add(item.get(1));
                dfs(Integer.parseInt(item.get(0)), dest, t);
                t.remove(t.size() - 1);
            }
        }
    }

}
