package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2792. Count Nodes That Are Great Enough.
 */
class Problem2792 extends LeetcodeProblem {

    private int k;
    private int ans;

    int countGreatEnoughNodes(TreeNode _root, int _k) {
        k = _k;
        dfs(_root);
        return ans;
    }

    private PriorityQueue<Integer> dfs(TreeNode root) {
        if (root == null) {
            return new PriorityQueue<>(Comparator.reverseOrder());
        }
        var l = dfs(root.left);
        var r = dfs(root.right);
        for (int x : r) {
            l.offer(x);
            if (l.size() > k) {
                l.poll();
            }
        }
        if (l.size() == k && l.peek() < root.val) {
            ans++;
        }
        l.offer(root.val);
        if (l.size() > k) {
            l.poll();
        }
        return l;
    }

}
